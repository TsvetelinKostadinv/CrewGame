

/*
 * 03/11/2018 at 15:13:11 ÷.
 * RaceInformation.java created by Tsvetelin
 */
package com.crewgame.people.races.definition;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.crewgame.people.PersonRelatedGameObject;
import com.utils.Pair;

/**
 * 
 * This is a information object which maps a characteristic to a characteristic name
 * 
 * @author Tsvetelin
 *
 */
public class RaceInformation implements PersonRelatedGameObject
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Map< String , Object > characteristics 
                    = Collections.synchronizedMap( new LinkedHashMap< String , Object >() );
    private Map< String , Class< ? > > types 
                    = Collections.synchronizedMap( new LinkedHashMap< String , Class< ? > >() );
    
    /**
     * 
     * Adds a new characteristic with the supplied name and value
     * 
     * @param characteristicName - the name which will be associated with the value
     * @param characteristic - the actual value
     */
    public void addCharactersitic( String characteristicName, Object characteristic )
    {
        characteristics.putIfAbsent( characteristicName , characteristic );
        types.putIfAbsent( characteristicName , characteristic.getClass() );
    }
    
    /**
     * 
     * Replaces the value of the supplied characteristic with the new value. <br>
     * 
     * NOTE: The new characteristic should be the same type as the previous
     * 
     * @param characteristicName - the name of the modified characteristic
     * @param newCharacteristic - the new characteristic
     * @throws IllegalArgumentException - if the supplied characteristic is not the same type
     */
    public void modifyCharacteristic( String characteristicName, Object newCharacteristic)
    {
        if( types.get( characteristicName ).isInstance( newCharacteristic ) )
        {
            characteristics.put( characteristicName , newCharacteristic );
        }else {
            throw new IllegalArgumentException( "The new characteristic has to be the same type as the old one!" );
        }
    }
    
    /**
     * 
     * @param characteristicName - the name of the characteristic
     * @return a <code>Pair</code> of the value and it's type
     */
    public Pair< Object , Class< ? > > getCharacteristic ( String characteristicName )
    {
        return new Pair< Object , Class< ? > >
        ( characteristics.get( characteristicName ) , types.get( characteristicName ) );
    }
    
    /**
     * 
     * @param characteristic - the characteristic name
     * @return true if it exists and false otherwise
     */
    public boolean containsCharacteristic( String characteristic )
    {
        return characteristic.contains( characteristic );
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "This is a race characteristic which holds: " + System.lineSeparator() );
        
        for ( Map.Entry< String , Object > entry : characteristics.entrySet() )
        {
            sb.append( "Key: " + entry.getKey() + " with value: " + entry.getValue().toString() + System.lineSeparator() );
        }
        
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof RaceInformation
                && ( ( RaceInformation ) obj ).characteristics.equals( this.characteristics )
                && ( ( RaceInformation ) obj ).types.equals( this.types );
    }
    
    
}
