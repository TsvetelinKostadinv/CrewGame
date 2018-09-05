

/*
 * 02/09/2018 at 15:21:01
 * WorldTileInfo.java created by Tsvetelin
 */
package com.crewgame.java.world.maps.worldTile.worldTileProperties;

import java.util.LinkedList;
import java.util.List;

import com.crewgame.java.utils.Pair;

/**
 * @author Tsvetelin
 *
 */
public class WorldTileProperties implements PropertyGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private List< Object > properties;
    
    
    /**
     * 
     */
    public WorldTileProperties ()
    {
        properties = new LinkedList< Object >();
    }
    
    /**
     * 
     * Adds the supplied <code>WorldTileProperty</code> to the list
     * 
     * @param prop - the resource to be added
     * 
     * 
     * @throws IllegalArgumentException - if it already contains the resource or supplied resource is null
     */
    public void addProperty(Object prop) throws IllegalArgumentException
    {
        if(!this.properties.contains( prop ) )
        {
            if( hasAnnotation(prop) )
            {
                if(prop != null)
                {
                    this.properties.add( prop );
                }else {
                    throw new IllegalArgumentException( "Cannot add a null element" );
                }
            }else {
                throw new IllegalArgumentException( "The added property must have a @WorldTileProperty annotation" );
            }
            
        }else {
            throw new IllegalArgumentException("Cannot have the same property added twice");
        }
    }
    
    /**
     * @param prop
     * @return
     */
    private boolean hasAnnotation ( Object prop )
    {
        return prop.getClass().isAnnotationPresent( WorldTileProperty.class );
    }

    /**
     * 
     * Removes ALL instances of the supplied <code>WorldTileProperty</code> object
     * 
     * @param prop - the <code>WorldTileProperty</code> objects to be removed
     */
    public void removeProperty ( WorldTileProperty prop )
    {
        do
        {
            this.properties.remove( prop );
        } while ( this.properties.contains( prop ) );
    }
    /**
     * 
     * 
     * @return a copy of the properties
     */
    public List<Object> getProperties(  )
    {
        return new LinkedList<>(this.properties);
    }
    
    /**
     * 
     * @param index
     * @return the <code>Class</code> of the property at the given index
     */
    public Class< ? > getClassOfIndex( int index )
    {
        return this.properties.get( index ).getClass();
    }
    
    /**
     * 
     * @param index
     * @return the uncast property at the given index
     */
    public Object getUncastedProperyAt( int index )
    {
        return this.properties.get( index );
    }
    
    /**
     * 
     * @param propertyClass - the class to be checked against
     * @return whether the properties contain the given <code>Class</code>
     */
    public boolean hasTilePropertyClass( Class< ? > propertyClass )
    {
        for(Object prop : properties)
        {
            if(prop.getClass().equals( propertyClass ) )
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param propertyClass - the class to be checked against
     * @return the index of the class or -1 if it does not contain it
     */
    public int getIndexOfProperyClass( Class< ? > propertyClass )
    {
        for ( int i = 0;i<properties.size();i++)
        {
            
            if ( properties.get( i ).getClass().equals( propertyClass ) )
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public Pair< Class< ? >, Object> getClassObjectPairAtIndex(int index)
    {
        return new Pair< Class<?> , Object >( getClassOfIndex( index ) , getUncastedProperyAt( index ) );
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "This property list contains " + properties.size() + " elements" );
        sb.append( System.lineSeparator() );
        for ( Object worldTileProperty : properties )
        {
            sb.append( worldTileProperty.toString() );
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
        return ((WorldTileProperties) obj).properties.equals( this.properties );
    }
    

}
