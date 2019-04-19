

/*
 * 14/10/2018 at 18:06:21
 * RaceDefinition.java created by Tsvetelin
 */
package com.crewgame.people.races.definition;


import java.util.LinkedList;
import java.util.List;

import com.crewgame.people.PersonRelatedGameObject;
import com.crewgame.people.races.RaceRelationships;
import com.crewgame.people.races.indicators.RaceIndicator;


/**
 * 
 * This object defines a race's characteristics.
 * 
 * @author Tsvetelin
 *
 */
public class RaceDefinition implements PersonRelatedGameObject
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    

    private final RaceIndicator indicator;



    private String name;


    private RaceInformation info;


    private List< RaceDefinition > alliedRaces;


    private List< RaceDefinition > enemyRaces;


    /**
     * @param name
     *            - the name of the race
     * @param info
     *            - info object for the race
     * @param alliedRaces
     *            - the list of allied races
     * @param enemyRaces
     *            - the list of enemy races
     */
    public RaceDefinition ( String name , RaceInformation info , List< RaceDefinition > alliedRaces ,
            List< RaceDefinition > enemyRaces )
    {

        super();
        this.name = name;
        this.indicator = new RaceIndicator( this.name );
        this.info = info;

        if ( !checkForDuplicateRaces( alliedRaces , enemyRaces ) )
        {
            this.alliedRaces = alliedRaces;
            this.enemyRaces = enemyRaces;
        } else
        {
            throw new IllegalArgumentException( "The list cannot have common elements!!" );
        }


    }


    /**
     * @param name
     * @param info
     */
    public RaceDefinition ( String name , RaceInformation info )
    {

        super();
        this.name = name;
        this.info = info;
        
        this.indicator = new RaceIndicator( this.name );

        this.alliedRaces = new LinkedList< RaceDefinition >();
        this.enemyRaces = new LinkedList< RaceDefinition >();
    }


    /**
     * 
     * Checks whether the lists have common elements.
     * 
     * @param allied
     * @param enemy
     * @return
     */
    private boolean checkForDuplicateRaces ( List< RaceDefinition > allies , List< RaceDefinition > enemies )
    {

        for ( RaceDefinition race : alliedRaces )
        {
            if ( enemies.contains( race ) ) { return true; }
        }
        return false;
    }


    /**
     * 
     * @param raceToCheck
     *            - the race which will be checked
     * @return true if the supplied race is enemy to the current race and false
     *         otherwise
     */
    public boolean isEnemyRace ( RaceDefinition raceToCheck )
    {

        return enemyRaces.contains( raceToCheck );
    }


    /**
     * 
     * @param raceToCheck
     *            - the race which will be checked
     * @return true if the supplied race is ally to the current race and false
     *         otherwise
     */
    public boolean isAlliedRace ( RaceDefinition raceToCheck )
    {

        return alliedRaces.contains( raceToCheck );
    }


    /**
     * 
     * @param raceToCheck
     *            the race which will be checked against
     * @return A <code>RaceRelationship</code> which represents the relationship
     * 
     * @see RaceRelationship
     */
    public RaceRelationships whatIsRelationship ( RaceIndicator raceToCheck )
    {
        
        boolean isAllied = alliedRaces.stream()
                                        .map( x -> x.getIndicator() )
                                        .filter( x -> x.equals( raceToCheck ) )
                                        .findAny().isPresent();
        boolean isEnemy = enemyRaces.stream()
                                        .map( x -> x.getIndicator() )
                                        .filter( x -> x.equals( raceToCheck ) )
                                        .findAny().isPresent();
        
        if ( isAllied )
        {
            return RaceRelationships.ALLIED;
        } else if ( isEnemy )
        {
            return RaceRelationships.ENEMIES;
        } else
        {
            return RaceRelationships.NOT_INTERESTED;
        }
    }


    /**
     * 
     * Adds the race to the corresponding list depending on the type of the
     * relationship
     * 
     * @param race
     *            - the race to be added
     * @param relationship
     *            - the relationship between the races
     */
    public void addRace ( RaceDefinition race , RaceRelationships relationship )
    {

        if ( this.whatIsRelationship( race.getIndicator() ) == RaceRelationships.NOT_INTERESTED )
        {
            if ( relationship.equals( RaceRelationships.ALLIED ) )
            {
                alliedRaces.add( race );
            } else if ( relationship.equals( RaceRelationships.ENEMIES ) )
            {
                enemyRaces.add( race );
            }
        }else {
            throw new UnsupportedOperationException( "Cannot add if it is already in the lists" );
        }

    }

    /**
     * 
     * Creates a <code>RaceIndicator</code> object which represents this race.
     * 
     * @return
     */
    public RaceIndicator getIndicator ()
    {
        return indicator;
    }
    
    /**
     * 
     * @param indicator - the indicator to be checked against
     * @return true if the indicator is of this race
     */
    public boolean isIndicatorOfRace( RaceIndicator indicator)
    {
        return indicator.getName().equals( this.name );
    }


    /**
     * @return the name
     */
    public String getName ()
    {

        return name;
    }


    /**
     * @return the info
     */
    public RaceInformation getInfo ()
    {

        return info;
    }


    /**
     * @param info
     *            the info to set
     */
    public void setInfo ( RaceInformation info )
    {

        this.info = info;
    }


    /**
     * @return the alliedRaces
     */
    public List< RaceDefinition > getAlliedRaces ()
    {

        return alliedRaces;
    }


    /**
     * @param alliedRaces
     *            the alliedRaces to set
     */
    public void setAlliedRaces ( List< RaceDefinition > alliedRaces )
    {

        this.alliedRaces = alliedRaces;
    }


    /**
     * @return the enemyRaces
     */
    public List< RaceDefinition > getEnemyRaces ()
    {

        return enemyRaces;
    }


    /**
     * @param enemyRaces
     *            the enemyRaces to set
     */
    public void setEnemyRaces ( List< RaceDefinition > enemyRaces )
    {

        this.enemyRaces = enemyRaces;
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

        sb.append( "This is a race with name: " + this.name + System.lineSeparator() );

        sb.append(
                "Allied races are: " + alliedRaces.toString().replaceAll( "[\\[\\]]" , "" ) + System.lineSeparator() );

        sb.append( "Enemy races are: " + enemyRaces.toString().replaceAll( "[\\[\\]]" , "" ) + System.lineSeparator() );

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

        return obj instanceof RaceDefinition && ( (RaceDefinition) obj ).alliedRaces.equals( this.alliedRaces )
                && ( (RaceDefinition) obj ).enemyRaces.equals( this.enemyRaces );
    }


}
