
/*
 * 31/08/2018 at 14:16:31
 * AvalilableResourcesProperty.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.swing.ImageIcon;

import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperties;
import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperty;
import com.crewgame.world.resources.Resource;


/**
 * 
 * A simple data container for the available resources of a given object
 * 
 * @author Tsvetelin
 *
 */
public class AvailableResources implements WorldTileProperty
{

    /**
     * 
     */
    private static final long      serialVersionUID = 1L;

    private final List< Resource > resources        = new ArrayList< Resource >();

    /**
     * 
     * @param resources
     *            - the <code>List</code> to be assigned
     * @throws IllegalArgumentException
     *             if the supplied list contains duplicate <code>Resource</code>
     *             instances
     */
    private AvailableResources ( List< Resource > resources )
    {
        this.resources
                .addAll( resources != null ? resources : Collections.emptyList() );
    }

    private AvailableResources ( List< Resource > resources , Resource res )
    {
        if ( resources != null )
        {
            resources.add( res );
            this.resources.addAll( resources );
        }
    }

    public static AvailableResources empty ()
    {
        return new AvailableResources( null );
    }

    /**
     * 
     * Adds the supplied resource to the list
     * 
     * @param res
     *            - the resource to be added
     * 
     * 
     * @throws IllegalArgumentException
     *             - if it already contains the resource or supplied resource is
     *             null
     */
    public AvailableResources addResource ( Resource res )
            throws IllegalArgumentException
    {
        Objects.requireNonNull( res );

        if ( !this.resources.contains( res ) )
        {
            return new AvailableResources( this.resources , res );
        } else
        {
            throw new IllegalArgumentException(
                    "Cannot have the same resource added twice"
            );
        }
    }

    /**
     * 
     * Removes ALL instances of the supplied <code>Resource</code> object
     * 
     * @param res
     *            - the <code>Resource</code> objects to be removed
     */
    public AvailableResources removeResource ( Resource res )
    {
        List< Resource > cpy = this.resources;
        cpy.removeIf( x -> x.equals( res ) );
        return new AvailableResources( cpy );
    }

    /**
     * @return the resources
     */
    public List< Resource > getResources ()
    {

        return new ArrayList< Resource >( this.resources );
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperty#
     * init(com.crewgame.world.maps.worldTile.worldTileProperties.
     * WorldTileProperties)
     */
    @Override
    public WorldTileProperties init ( WorldTileProperties otherProps )
    {
        return otherProps;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperty#
     * getIcon()
     */
    @Override
    public ImageIcon getIcon ()
    {
        // TODO Make it return it's icon
        return null;
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
        sb.append( "Resource list containing : " + this.resources.size() );
        sb.append( System.lineSeparator() );
        for ( int i = 0 ; i < this.resources.size() ; i++ )
        {
            Resource res = this.resources.get( i );
            sb.append( " - N" + i + " " );
            sb.append( res.toString() );
            sb.append( System.lineSeparator() );
        }

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
        return this.resources.equals( ( (AvailableResources) obj ).resources );
    }

}
