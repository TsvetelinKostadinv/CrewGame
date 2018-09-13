

/*
 * 10/09/2018 at 13:47:01
 * Multipliers.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties.multipliersProperty;

import java.lang.reflect.Field;
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
public class Multipliers
{
    private final Map< Field, Function< Field, Field > > multipliers = new HashMap<>();
    
    /**
     * Applies the functions from the map to the supplied set of Fields
     * 
     * @param fields - the set of field to which the functions will be applied
     * @return the set after the application of those functions
     */
    public Set<Field> applyMultipliers ( Set<Field> fields )
    {
        Set<Field> res = new HashSet<>();
        for(Field f : fields)
        {
            if(this.multipliers.containsKey( f ))
            {
                res.add( applyToSingleField( f ) );
            }
        }
        return res;
    }
    
    private Field applyToSingleField(Field f)
    {
        return this.multipliers.get( f ).apply( f );
    }
    
    /**
     * 
     * Adds the multiplier, however, will replace old <code>Function</code> with the new one
     * 
     * @param field - the field to be operated on
     * @param func - the function to be applied
     */
    public void addMultiplier ( Field field, Function< Field , Field > func)
    {
        multipliers.put( field , func );
    }
    
    /**
     * @return the multipliers
     */
    public Map< Field , Function< Field , Field > > getMultipliers ()
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
        sb.append( "There are " + multipliers.size() + " multipliers" );
        for ( Map.Entry< Field , Function< Field, Field > > entry : multipliers.entrySet() )
        {
            sb.append( "Field with name" + entry.getKey().getName() + " with function: " + entry.getValue().toString() );
        }
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof Multipliers && ( (Multipliers) obj ).multipliers.equals( this.multipliers );
    }
}
