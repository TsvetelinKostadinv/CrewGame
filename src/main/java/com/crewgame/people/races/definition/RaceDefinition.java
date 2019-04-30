
/*
 * 14/10/2018 at 18:06:21
 * RaceDefinition.java created by Tsvetelin
 */
package com.crewgame.people.races.definition;


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.crewgame.people.PersonRelatedGameObject;
import com.crewgame.people.races.RaceRelationships;
import com.crewgame.people.races.definition.indicators.RaceIndicator;
import com.crewgame.people.races.definition.statistics.RaceMultipliers;
import com.utils.Pair;


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
    private static final long          serialVersionUID = 1L;

    private final String               name;

    private final RaceIndicator        indicator;

    private final RaceMultipliers      stats;

    private final Set< RaceIndicator > alliedRaces      = new HashSet<>();

    private final Set< RaceIndicator > enemyRaces       = new HashSet<>();

    /**
     * @param name
     *            - the name of the race
     * @param alliedRaces
     *            - the list of allied races
     * @param enemyRaces
     *            - the list of enemy races
     */
    private RaceDefinition (
            String name ,
            RaceMultipliers stats ,
            Set< RaceIndicator > alliedRaces ,
            Set< RaceIndicator > enemyRaces )
    {
        this.name = name;
        this.indicator = new RaceIndicator( this.name );

        this.stats = stats;

        this.alliedRaces
                .addAll(
                        alliedRaces != null ? alliedRaces
                                : Collections.emptySet() );
        this.enemyRaces
                .addAll(
                        enemyRaces != null ? enemyRaces
                                : Collections.emptySet() );
    }

    private RaceDefinition (
            String name ,
            RaceMultipliers stats ,
            Set< RaceIndicator > alliedRaces ,
            Set< RaceIndicator > enemyRaces ,
            RaceIndicator enemy )
    {
        enemyRaces.add( enemy );

        this.name = name;
        this.indicator = new RaceIndicator( this.name );

        this.stats = stats;

        this.alliedRaces
                .addAll(
                        alliedRaces != null ? alliedRaces
                                : Collections.emptySet() );
        this.enemyRaces
                .addAll(
                        enemyRaces != null ? enemyRaces
                                : Collections.emptySet() );
    }

    private RaceDefinition (
            String name ,
            RaceMultipliers stats ,
            Set< RaceIndicator > alliedRaces ,
            RaceIndicator alliedRace ,
            Set< RaceIndicator > enemyRaces )
    {
        alliedRaces.add( alliedRace );
        this.name = name;
        this.indicator = new RaceIndicator( this.name );

        this.stats = stats;

        this.alliedRaces
                .addAll(
                        alliedRaces != null ? alliedRaces
                                : Collections.emptySet() );
        this.enemyRaces
                .addAll(
                        enemyRaces != null ? enemyRaces
                                : Collections.emptySet() );
    }

    /**
     * @param name
     * @param info
     */
    private RaceDefinition ( String name )
    {
        this.name = name;

        this.stats = new RaceMultipliers();

        this.indicator = new RaceIndicator( this.name );
    }

    /**
     * 
     */
    public static RaceDefinition create ( String name )
    {
        return new RaceDefinition( name );
    }

    /**
     * 
     * @param raceToCheck
     *            - the race which will be checked
     * @return true if the supplied race is enemy to the current race and false
     *         otherwise
     */
    public boolean isEnemyRace ( RaceIndicator raceToCheck )
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
    public boolean isAlliedRace ( RaceIndicator raceToCheck )
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

        if ( this.isAlliedRace( raceToCheck ) )
        {
            return RaceRelationships.ALLIED;
        } else if ( this.isEnemyRace( raceToCheck ) )
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
    private RaceDefinition addRace (
            RaceIndicator race ,
            RaceRelationships relationship )
    {

        if (
            this.whatIsRelationship( race ) == RaceRelationships.NOT_INTERESTED
        )
        {
            if ( relationship.equals( RaceRelationships.ALLIED ) )
                return new RaceDefinition(
                        this.name ,
                        this.stats ,
                        this.alliedRaces ,
                        race ,
                        this.enemyRaces );
            else if ( relationship.equals( RaceRelationships.ENEMIES ) )
                return new RaceDefinition(
                        this.name ,
                        this.stats ,
                        this.alliedRaces ,
                        this.enemyRaces ,
                        race );
            else return new RaceDefinition(
                    name ,
                    this.stats ,
                    alliedRaces ,
                    enemyRaces );
        }

        throw new UnsupportedOperationException(
                "Cannot add if it is already in the lists" );

    }

    public static interface RacesMediator
    {

        public static Pair< RaceDefinition , RaceDefinition > rivalry (
                RaceDefinition race1 ,
                RaceDefinition race2 )
        {
            return addThemAs( race1 , race2 , RaceRelationships.ENEMIES );
        }

        public static Pair< RaceDefinition , RaceDefinition > alliance (
                RaceDefinition race1 ,
                RaceDefinition race2 )
        {
            return addThemAs( race1 , race2 , RaceRelationships.ALLIED );
        }

        public static Pair< RaceDefinition , RaceDefinition > addThemAs (
                RaceDefinition race1 ,
                RaceDefinition race2 ,
                RaceRelationships relation )
        {
            return new Pair<>(
                    race1
                            .addRace(
                                    race2.getIndicator() ,
                                    relation ) ,
                    race2
                            .addRace(
                                    race1.getIndicator() ,
                                    relation ) );
        }
    }

    /**
     * @return the name
     */
    public String getName ()
    {

        return name;
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
     * @return the stats
     */
    public RaceMultipliers getStats ()
    {
        return stats;
    }

    /**
     * @return the alliedRaces
     */
    public List< RaceIndicator > getAlliedRaces ()
    {

        return new LinkedList<>( this.alliedRaces );
    }

    /**
     * @return the enemyRaces
     */
    public List< RaceIndicator > getEnemyRaces ()
    {

        return new LinkedList<>( this.enemyRaces );
    }

    /**
     * 
     * @param indicator
     *            - the indicator to be checked against
     * @return true if the indicator is of this race
     */
    public boolean isIndicatorOfRace ( RaceIndicator indicator )
    {
        return indicator.getName().equals( this.name );
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

        sb
                .append(
                        "This is a race with name: " + this.name
                                + System.lineSeparator() );

        sb
                .append(
                        "Allied races are: " + alliedRaces
                                .toString()
                                .replaceAll( "[\\[\\]]" , "" )
                                + System.lineSeparator() );

        sb
                .append(
                        "Enemy races are: " + enemyRaces
                                .toString()
                                .replaceAll( "[\\[\\]]" , "" )
                                + System.lineSeparator() );

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

        return obj instanceof RaceDefinition
                && ( (RaceDefinition) obj ).name.equals( this.name );
    }

}
