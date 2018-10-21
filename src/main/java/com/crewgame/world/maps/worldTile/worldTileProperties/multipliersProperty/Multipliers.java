

/*
 * 10/09/2018 at 13:47:01
 * Multipliers.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties.multipliersProperty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperty;

/**
 * @author Tsvetelin
 *
 */
@WorldTileProperty ( propertyClass = Multipliers.class )
public class Multipliers< Type >
{
    private final Map< Type, Function< Type, Type > > multipliers = new HashMap<>();
    
    /**
     * Applies the functions from the map to the supplied set of Fields
     * 
     * @param objects - the set of field to which the functions will be applied
     * @return the set after the application of those functions
     */
    public Set<Type> applyMultipliers ( Set<Type> objects )
    {
        Set<Type> res = new HashSet<>();
        for(Type f : objects)
        {
            if(this.multipliers.containsKey( f ))
            {
                res.add( applyToSingleObject( f ) );
            }
        }
        return res;
    }
    
    /**
     * Applies the functions from the map to the supplied array of Fields
     * 
     * @param objects - the set of field to which the functions will be applied
     * @return the set after the application of those functions
     */
    public Set<Type> applyMultipliers ( Type[] objects )
    {
        Set<Type> res = new HashSet<>();
        
        for(Type f : objects)
        {
            if(this.multipliers.containsKey( f ))
            {
                res.add( applyToSingleObject( f ) );
            }
        }
        return res;
    }
    
    private Type applyToSingleObject(Type object)
    {
        return this.multipliers.get( object ).apply( object );
    }
    
    /**
     * 
     * Adds the multiplier, however, will replace old <code>Function</code> with the new one
     * 
     * @param type - the field to be operated on
     * @param func - the function to be applied
     */
    public void addMultiplier ( Type type, Function< Type , Type > func)
    {
        multipliers.put( type , func );
    }
    
    /**
     * @return the multipliers
     */
    public Map< Type , Function< Type , Type > > getMultipliers ()
    {
    
        return multipliers;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {       
        StringBuilder sb = new StringBuilder();
        sb.append( "There are " + multipliers.size() + " multipliers" + System.lineSeparator() );
        for ( Map.Entry< Type , Function< Type, Type > > entry : multipliers.entrySet() )
        {
            sb.append( "From type: " + entry.getKey().getClass().getSimpleName()
                    + " applies function " + entry.getValue().toString() );
        }
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof Multipliers
                && ( ( Multipliers< ? > ) obj ).multipliers.equals( this.multipliers );
    }
}
