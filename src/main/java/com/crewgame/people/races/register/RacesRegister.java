
/*
 * 02/11/2018 at 15:12:24 ÷.
 * RacesContainer.java created by Tsvetelin
 */
package com.crewgame.people.races.register;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.crewgame.people.PersonRelatedGameObject;
import com.crewgame.people.races.definition.RaceDefinition;
import com.crewgame.people.races.definition.indicators.RaceIndicator;


/**
 * 
 * A register of all created races. To be recognized as a race it has to be
 * registered here
 * 
 * @author Tsvetelin
 *
 */
public class RacesRegister implements Iterable< RaceDefinition > , PersonRelatedGameObject
{

    /**
     * 
     */
    private static final long            serialVersionUID = 1L;

    private final List< RaceDefinition > races            = new ArrayList< RaceDefinition >();

    private RacesRegister ()
    {}

    private RacesRegister ( List< RaceDefinition > races , RaceDefinition race )
    {
        races.add( race );
        this.races.addAll( races );
    }

    public RacesRegister empty ()
    {
        return new RacesRegister();
    }

    /**
     * 
     * Checks whether the race exists
     * 
     * @param indicator
     *            - the indicator of the searched race
     * @return true if the race is registered and false otherwise
     */
    public boolean raceExists ( RaceIndicator indicator )
    {

        return this.races
                .stream()
                .map( x -> x.getIndicator() )
                .filter( x -> x.equals( indicator ) )
                .findAny()
                .isPresent();
    }

    /**
     * 
     * Checks whether the race exists
     * 
     * @param indicator
     *            - the indicator of the searched race
     * @return true if the race is registered and false otherwise
     */
    public boolean raceExists ( String name )
    {
        return raceExists( new RaceIndicator( name ) );
    }

    /**
     * 
     * @param race
     *            - the race to be added
     */
    public RacesRegister addRace ( RaceDefinition race )
    {
        if (
            !races.contains( race )
        ) { return new RacesRegister( this.races , race ); }
        throw new UnsupportedOperationException(
                "Cannot add it if it already exists!"
        );
    }

    /**
     * 
     * Creates indicator
     * 
     * @param name
     *            of the race
     * @return An optional of an indicator, if the race exists the Optional is
     *         filled, it is empty otherwise
     */
    public Optional< RaceIndicator > getIndicator ( String name )
    {
        return races
                .stream()
                .map( x -> x.getIndicator() )
                .filter( x -> x.getName().equals( name ) )
                .findFirst();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator< RaceDefinition > iterator ()
    {
        return races.iterator();
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
        sb.append( "This is the register of races" + System.lineSeparator() );

        for ( RaceDefinition raceDefinition : this )
        {
            sb.append( raceDefinition.toString() );
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
        return obj instanceof RacesRegister
                && ( (RacesRegister) obj ).races.equals( this.races );
    }
}
