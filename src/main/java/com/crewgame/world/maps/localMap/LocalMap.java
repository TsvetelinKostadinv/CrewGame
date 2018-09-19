

/*
 * 06/09/2018 at 15:15:02
 * LocalMap.java created by Tsvetelin
 */
package com.crewgame.world.maps.localMap;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.crewgame.exceptions.TileOccupiedException;
import com.crewgame.world.WorldGameObject;
import com.crewgame.world.maps.worldTile.WorldTile;
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
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static transient final int X_RANGE = 100;
    public static transient final int Y_RANGE = 100;
    
    
    private final Map<Coordinate, WorldTile> map = 
            Collections.synchronizedMap( new TreeMap<Coordinate, WorldTile>( Coordinate.COORDINATE_COMPARATOR ) );

    /**
     * @return the map
     */
    public Map<Coordinate, WorldTile> getMap ()
    {

        return map;
    }
    
    /**
     * 
     * Inserts the supplied <code>WorldTile</code> on the supplied <code>Coordinate</code>
     * 
     * @param coord - on which coordinate to be put
     * @param tile - the tile which will be inserted
     * @throws TileOccupiedException - if the tile is occupied
     * @throws IllegalArgumentException - if the supplied arguments are <code>null</code> or x or y are less than zero
     */
    public void addTile( Coordinate coord, WorldTile tile ) throws TileOccupiedException, IllegalArgumentException
    {
        if(!map.containsKey( coord ))
        {
            if(coord != null && tile != null)
            {
                if(coord.getX()>=0 && coord.getY()>=0)
                {
                    map.put( coord , tile );
                }else {
                    throw new IllegalArgumentException("The supplied coordinates cannot be less than 0");
                }
                
            }else {
                throw new IllegalArgumentException( "The supplied arguements cannot be null" );
            }
            
        }else {
            throw new TileOccupiedException("The supplied coorinates are occupied");
        }
    }
    
    /**
     * 
     * Inserts the supplied tile on the next free tile starting from 0,0    <br>
     * and going through all the available x values and then moving to the next y
     * 
     * @param tile - the tile to be inserted
     * @throws IllegalArgumentException -  if the supplied arguments are <code>null</code>
     */
    public void insertOnNextAvailableCorrdinate ( WorldTile tile ) throws IllegalArgumentException
    {
        Coordinate c = new Coordinate( 0 , 0 );
        for(int x = 0; x < X_RANGE; x++ )
        {
            for(int y = 0; y < X_RANGE; y++ )
            {
                c.setX( x );
                c.setY( y );
                try
                {
                    addTile( c , tile );
                    return;
                } catch ( TileOccupiedException e )
                {
                    continue;
                }
            }
        }
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "This map contains: " + map.size() );
        for(Map.Entry< Coordinate , WorldTile > entry : map.entrySet())
        {
            sb.append( "Coordinates: " + entry.getKey().toString() );
            sb.append( "World tile: " + entry.getValue().toString() );
        }
        return super.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof LocalMap && ((LocalMap) obj ).map.equals( this.map );
    }

}
