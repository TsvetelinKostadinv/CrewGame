

/*
 * 02/11/2018 at 15:12:24 ÷.
 * RacesContainer.java created by Tsvetelin
 */
package com.crewgame.people.races.register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crewgame.people.PersonRelatedGameObject;
import com.crewgame.people.races.definition.RaceDefinition;
import com.crewgame.people.races.definition.RaceIndicator;

/**
 * 
 * A register of all created races. To be recognized as a race it has to be registered here
 * 
 * @author Tsvetelin
 *
 */
public class RacesRegister implements Iterable< RaceDefinition >, PersonRelatedGameObject
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static final RacesRegister INSTANCE = new RacesRegister();
    
    private List< RaceDefinition > races = new ArrayList< RaceDefinition >();
    
    private RacesRegister() {}
    
    /**
     * 
     * Checks whether the race exists
     * 
     * @param indicator - the indicator of the searched race
     * @return true if the race is registered and false otherwise
     */
    public boolean raceExists( RaceIndicator indicator )
    {
        for( RaceDefinition def : this )
        {
            if( def.getName().equals( indicator.getName() ) )
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * Checks whether the race exists
     * 
     * @param indicator - the indicator of the searched race
     * @return true if the race is registered and false otherwise
     */
    public boolean raceExists( String name )
    {
        return raceExists( new RaceIndicator( name ) );
    }
    
    /**
     * 
     * @param race - the race to be added
     */
    public void addRace ( RaceDefinition race )
    {
        if(!races.contains( race ) )
        {
            races.add( race );
        }
    }
    
    /**
     * 
     * Creates indicator
     * 
     * @param name of the race
     * @return the indicator of the race if it exists and <code>null</code> otherwise
     */
    public RaceIndicator createIndicator( String name )
    {
        for( RaceDefinition race : this )
        {
            if( race.getName().equals( name ) )
            {
                return race.createIndicator();
            }
        }
        return null;
    }
    
    /**
     * 
     * Adds the characteristic to the race with the supplied name
     * 
     * @param name - the name of the race
     * @param characteristicName - the name of the characteristic
     * @param characteristic - the value of the characteristic
     */
    public void putInfoInRace( String name, String characteristicName, Object characteristic )
    {
        for( RaceDefinition race : this )
        {
            if(race.getName().equals( name ) )
            {
                if( race.getInfo().containsCharacteristic( characteristicName ) )
                {
                    race.getInfo().modifyCharacteristic( characteristicName , characteristic );
                    return;
                }else {
                    race.getInfo().addCharactersitic( characteristicName , characteristic );
                }
            }
        }
    }
    
    /**
     * 
     * Adds the characteristic to the race with the supplied indicator
     * 
     * @param indicator - the indicator of the race
     * @param characteristicName - the name of the characteristic
     * @param characteristic - the value of the characteristic
     */
    public void putInfoInRace( RaceIndicator indicator, String characteristicName, Object characteristic )
    {
        for( RaceDefinition race : this )
        {
            if( race.isIndicatorOfRace( indicator ) )
            {
                if( race.getInfo().containsCharacteristic( characteristicName ) )
                {
                    race.getInfo().modifyCharacteristic( characteristicName , characteristic );
                    return;
                }else {
                    race.getInfo().addCharactersitic( characteristicName , characteristic );
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator< RaceDefinition > iterator ()
    {
        return races.iterator();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "This is the register of races" + System.lineSeparator() );
        
        for ( RaceDefinition raceDefinition : this )
        {
            sb.append( raceDefinition.toString() );
        }
        
        return sb.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof RacesRegister
                && ( ( RacesRegister ) obj ).races.equals( this.races );
    }
}
