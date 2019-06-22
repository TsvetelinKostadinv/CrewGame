
/*
 * 02/09/2018 at 15:21:01
 * WorldTileInfo.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;


/**
 * 
 * A container for all the properties of a given tile
 * 
 * @author Tsvetelin
 *
 */
public class WorldTileProperties implements PropertyGameObject , Iterable< WorldTileProperty >
{

    /**
     * 
     */
    private static final long              serialVersionUID = 1L;

    private final Set< WorldTileProperty > properties       = new HashSet<>();

    private WorldTileProperties ( Set< WorldTileProperty > props )
    {

        this.properties.addAll( props );
    }

    // incremental constructor
    private WorldTileProperties (
            Set< WorldTileProperty > props ,
            WorldTileProperty prop )
    {
        this.properties.addAll( props );
        this.properties.add( prop );
    }

    private WorldTileProperties ( WorldTileProperty... props )
    {

        this.properties
                .addAll(
                        props != null ? Arrays.asList( props )
                                : Collections.emptySet() );

    }

    public static WorldTileProperties empty ()
    {
        return new WorldTileProperties();
    }

    /**
     * 
     * Adds the supplied <code>WorldTileProperty</code> to the list
     * 
     * @param prop
     *            - the resource to be added
     * 
     * 
     * @throws IllegalArgumentException
     *             - if it already contains the resource, supplied resource is
     *             null
     *             or the supplied object does not have an @WorldTileProperty
     *             annotation
     */
    public WorldTileProperties addProperty ( WorldTileProperty prop )
            throws IllegalArgumentException
    {

        Objects.requireNonNull( prop );

        if ( !this.properties.contains( prop ) )
        {
            return new WorldTileProperties( this.properties , prop );
        } else
        {
            throw new IllegalArgumentException(
                    "Cannot have the same property added twice" );
        }
    }

    /**
     * 
     * Removes ALL instances of the supplied <code>WorldTileProperty</code>
     * object
     * 
     * @param prop
     *            - the <code>WorldTileProperty</code> objects to be removed
     */
    public WorldTileProperties removeProperty ( WorldTileProperty prop )
    {
        Set< WorldTileProperty > cpy = this.properties;

        cpy.removeIf( x -> x.equals( prop ) );

        return new WorldTileProperties( cpy );
    }

    /**
     * 
     * 
     * @return a copy of the properties
     */
    public Set< WorldTileProperty > getProperties ()
    {

        return new HashSet<>( this.properties );
    }

    /**
     * 
     * @param prop
     *            - the class to be checked against
     * @return whether the properties contain the given <code>Class</code>
     */
    public boolean hasTileProperty ( WorldTileProperty prop )
    {
        return this.properties.contains( prop );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator< WorldTileProperty > iterator ()
    {

        return this.properties.iterator();
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
        sb
                .append(
                        "This property list contains " + properties.size()
                                + " elements:" );
        sb.append( System.lineSeparator() );

        this.properties
                .forEach(
                        x -> sb
                                .append(
                                        x.toString()
                                                + System.lineSeparator() ) );

        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {

        return ( (WorldTileProperties) obj ).properties
                .equals( this.properties );
    }
}
