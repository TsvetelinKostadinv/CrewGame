
/*
 * 25/04/2019 at 13:18:48 ÷.
 * RaceMultipliers.java created by Tsvetelin
 */
package com.crewgame.people.races.definition.statistics;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Function;


/**
 * @author Tsvetelin
 *
 */
public class RaceMultipliers
{

    private final Map< String , Double > stats = new LinkedHashMap<>();

    /**
     * @param stats2
     * @param entry
     */
    private RaceMultipliers (
            Map< String , Double > stats ,
            Entry< String , Double > stat )
    {
        stats.put( stat.getKey() , stat.getValue() );
        this.stats.putAll( stats );
    }

    /**
     * 
     */
    public RaceMultipliers ()
    {}

    public Map< String , Double > getStats ()
    {
        return stats;
    }

    public RaceMultipliers addStat ( String name , Double value )
    {
        return new RaceMultipliers( this.stats , Map.entry( name , value ) );
    }

    public RaceMultipliers mapStat (
            String name ,
            Function< Double , Double > mapper )
    {
        Objects.requireNonNull( name );
        Objects.requireNonNull( mapper );

        return new RaceMultipliers(
                this.stats ,
                Map.entry( name , mapper.apply( this.stats.get( name ) ) ) );

    }

    public RaceMultipliers removeStat ( String name )
    {
        return this.mapStat( name , x -> null );
    }

}
