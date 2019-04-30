
/*
 * 25/04/2019 at 13:18:48 ÷.
 * RaceMultipliers.java created by Tsvetelin
 */
package com.crewgame.people.races.definition.statistics;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;


/**
 * @author Tsvetelin
 *
 */
public class RaceMultipliers
{

    private final Set< RaceStatistic > stats = new HashSet<>();

    /**
     * @param stats2
     * @param entry
     */
    private RaceMultipliers (
            Set< RaceStatistic > stats ,
            RaceStatistic stat )
    {
        stats.add( stat );
        this.stats.addAll( stats );
    }

    /**
     * 
     */
    public RaceMultipliers ()
    {}

    public Set< RaceStatistic > getStats ()
    {
        return stats;
    }

    public RaceMultipliers addStat ( RaceStatistic stat )
    {
        return new RaceMultipliers( this.stats , stat );
    }

    public RaceMultipliers mapStat (
            String name ,
            Function< RaceStatistic , RaceStatistic > mapper )
    {
        Objects.requireNonNull( name );
        Objects.requireNonNull( mapper );

        RaceStatistic stat = this.stats
                .stream()
                .filter( x -> x.getName().equals( name ) )
                .map( mapper )
                .findFirst()
                .get();

        return new RaceMultipliers(
                this.stats ,
                stat );

    }

    public RaceMultipliers removeStat ( String name )
    {
        return this.mapStat( name , x -> null );
    }

}
