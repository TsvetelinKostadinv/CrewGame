

/*
 * 03/11/2018 at 14:49:28 ÷.
 * RaceIndicator.java created by Tsvetelin
 */
package com.crewgame.people.races.definition.indicators;

import com.crewgame.people.PersonRelatedGameObject;

/**
 * 
 * A simple indicator for a race.
 * 
 * @author Tsvetelin
 *
 */
public final class RaceIndicator implements PersonRelatedGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final String name;
    
    /**
     * 
     */
    public RaceIndicator ( String name )
    {
        this.name = name;
    }
    
    /**
     * @return the name
     */
    public String getName ()
    {
        return name;
    }
}
