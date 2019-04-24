
/*
 * 06/09/2018 at 15:15:02
 * LocalMap.java created by Tsvetelin
 */
package com.crewgame.world.maps.localMap;


import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Predicate;

import com.crewgame.world.WorldGameObject;
import com.crewgame.world.maps.worldTile.WorldTile;
import com.utils.exceptions.TileOccupiedException;
import com.utils.mapNavigation.coordinates.Coordinate;


/**
 * 
 * This data structure represents the local map around the player
 * 
 * @author Tsvetelin
 *
 */
public class LocalMap implements WorldGameObject
{

    public static transient final LocalMap      EMPTY_LOCAL_MAP  = new LocalMap();

    /**
     * 
     */
    private static final long                   serialVersionUID = 1L;

    //
    public static transient final int           X_RANGE          = 100;

    public static transient final int           Y_RANGE          = 100;
    // These constants are to be removed if I want it to be open world

    private final Map< Coordinate , WorldTile > map              = new TreeMap< Coordinate , WorldTile >(
            Coordinate.COORDINATE_COMPARATOR
    );

    private LocalMap ()
    {}

    private LocalMap ( Map< Coordinate , WorldTile > map )
    {
        this.map.putAll( map != null ? map : Collections.emptyMap() );
    }

    private LocalMap (
            Map< Coordinate , WorldTile > map ,
            Map.Entry< Coordinate , WorldTile > tile
    )
    {
        map.put( tile.getKey() , tile.getValue() );
        this.map.putAll( map );
    }

    /**
     * @return the map
     */
    public Map< Coordinate , WorldTile > getMap ()
    {
        return new TreeMap<>( this.map );
    }

    /**
     * 
     * Inserts the supplied <code>WorldTile</code> on the supplied
     * <code>Coordinate</code>
     * 
     * @param coord
     *            - on which coordinate to be put
     * @param tile
     *            - the tile which will be inserted
     * @throws TileOccupiedException
     *             - if the tile is occupied
     * @throws IllegalArgumentException
     *             - if the supplied arguments are <code>null</code> or x or y
     *             are less than zero
     */
    public LocalMap addTile ( Coordinate coord , WorldTile tile )
            throws TileOccupiedException ,
            IllegalArgumentException
    {
        Objects.requireNonNull( coord );
        Objects.requireNonNull( tile );

        if ( coord.getX() < 0 && coord.getY() < 0 )
            throw new IllegalArgumentException(
                    "The supplied coordinates cannot be less than 0"
            );

        if ( !map.containsKey( coord ) )
        {
            Map.Entry< Coordinate , WorldTile > newEntry = Map
                    .entry( coord , tile );

            return new LocalMap( this.map , newEntry );
        } else
        {
            throw new TileOccupiedException(
                    "The supplied coorinates are occupied"
            );
        }
    }

    /**
     * 
     * Inserts the supplied tile on the next free tile starting from 0,0 <br>
     * and going through all the available y values and then moving to the next
     * y ( aka columns and then rows)
     * 
     * @param tile
     *            - the tile to be inserted
     * @throws IllegalArgumentException
     *             - if the supplied arguments are <code>null</code>
     */
    public LocalMap insertOnNextAvailableCorrdinate ( WorldTile tile )
            throws IllegalArgumentException
    {
        Objects.requireNonNull( tile );

        Coordinate c = new Coordinate( 0 , 0 );

        for ( long x = 0 ; x < X_RANGE ; x++ )
        {
            c = c.x( x );
            for ( long y = 0 ; y < X_RANGE ; y++ )
            {
                c = c.y( y );
                try
                {
                    return this.addTile( c , tile );
                } catch ( TileOccupiedException e )
                {
                    continue;
                }
            }
        }
        throw new UnsupportedOperationException( "The map is full!" );
    }

    public boolean isEmpty ()
    {
        return this.searchForNotContaining( x -> x != null );
    }

    public boolean isFull ()
    {
        return this.searchForNotContaining( x -> x == null );
    }

    /**
     * 
     * Tests every tile with the given filter.
     * 
     * @param filterForTile
     * @return true if the map contains a tile that matches the predicate and
     *         false otherwise
     */
    public boolean searchForFirstContaining (
            Predicate< WorldTile > filterForTile
    )
    {
        Coordinate c = new Coordinate( 0 , 0 );

        for ( long x = 0 ; x < X_RANGE ; x++ )
        {
            c = c.x( x );
            for ( long y = 0 ; y < X_RANGE ; y++ )
            {
                c = c.y( y );
                if ( filterForTile.test( this.map.get( c ) ) ) return true;
            }
        }
        return false;
    }

    /**
     * 
     * Tests every tile with the given filter.
     * 
     * @param filterForTile
     * @return false if the map contains a tile that matches the predicate and
     *         true otherwise
     */
    public boolean searchForNotContaining (
            Predicate< WorldTile > filterForTile
    )
    {
        Coordinate c = new Coordinate( 0 , 0 );

        for ( long x = 0 ; x < X_RANGE ; x++ )
        {
            c = c.x( x );
            for ( long y = 0 ; y < X_RANGE ; y++ )
            {
                c = c.y( y );
                if ( filterForTile.test( this.map.get( c ) ) ) return false;
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "This map contains: " + map.size() );
        for ( Map.Entry< Coordinate , WorldTile > entry : map.entrySet() )
        {
            sb.append( "Coordinates: " + entry.getKey().toString() );
            sb.append( "World tile: " + entry.getValue().toString() );
        }
        return super.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof LocalMap
                && ( (LocalMap) obj ).map.equals( this.map );
    }
}
