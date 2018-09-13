

/*
 * 31/08/2018 at 14:16:31
 * AvalilableResourcesProperty.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty;

import java.util.ArrayList;
import java.util.List;

import com.crewgame.world.maps.worldTile.worldTileProperties.PropertyGameObject;
import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperty;
import com.crewgame.world.resources.Resource;

/**
 * 
 * A simple data container for the available resources of a given object
 * 
 * @author Tsvetelin
 *
 */
@WorldTileProperty(
        propertyClass = AvailableResources.class)

public class AvailableResources implements PropertyGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private List< Resource > resources;
    
    
    /**
     * 
     */
    public AvailableResources ()
    {
        this.resources = new ArrayList< Resource >();
    }
    
    /**
     * 
     * @param resources - the <code>List</code> to be assigned
     * @throws IllegalArgumentException if the supplied list contains duplicate <code>Resource</code> instances
     */
    public AvailableResources (List< Resource > resources)
    {
        List<Resource> checker = new ArrayList<>();
        
        for(int i = 0;i<resources.size();i++)
        {
            if(checker.contains( resources.get( i ) ))
            {
               throw new IllegalArgumentException("Cannot have the same resource twice");
            }
            checker.add( resources.get( i ) );
            
        }
        this.resources = new ArrayList< Resource >(resources);
    }
    
    public AvailableResources(Resource...resources )
    {
        List<Resource> checker = new ArrayList<>();
        this.resources = new ArrayList< Resource >();
        
        for(int i = 0;i<resources.length;i++)
        {
            if(checker.contains( resources[i] ))
            {
               throw new IllegalArgumentException("Cannot have the same resource twice");
            }else {
                this.resources.add( resources[i] );
            }
            checker.add( resources[i] );
        }
        
    }
    
    /**
     * 
     * Adds the supplied resource to the list
     * 
     * @param res - the resource to be added
     * 
     * 
     * @throws IllegalArgumentException - if it already contains the resource or supplied resource is null
     */
    public void addResource(Resource res) throws IllegalArgumentException
    {
        if(!this.resources.contains( res ))
        {
            if(res != null)
            {
                this.resources.add( res );
            }else {
                throw new IllegalArgumentException( "Cannot add a null element" );
            }
            
        }else {
            throw new IllegalArgumentException("Cannot have the same resource added twice");
        }
    }
    
    /**
     * 
     * Removes ALL instances of the supplied <code>Resource</code> object
     * 
     * @param res - the <code>Resource</code> objects to be removed
     */
    public void removeResource ( Resource res )
    {
        do
        {
            this.resources.remove( res );
        } while ( this.resources.contains( res ) );
    }
    
    /**
     * @return the resources
     */
    public List< Resource > getResources ()
    {

        return new ArrayList< Resource >(this.resources);
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "Resource list containing : " + this.resources.size() );
        sb.append( System.lineSeparator() );
        for(int i = 0; i < this.resources.size();i++)
        {
            Resource res = this.resources.get( i );
            sb.append( "N" + i + " " );
            sb.append( res.toString() );
            sb.append( System.lineSeparator() );
        }
        
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return this.resources.equals( ( (AvailableResources) obj ).resources );
    }
    

}
