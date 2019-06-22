
/*
 * 29/04/2019 at 13:54:11 ÷.
 * RaceStatistic.java created by Tsvetelin
 */
package com.crewgame.people.races.definition.statistics;


/**
 * 
 * A template for a race statistic used to compute final race multipliers and
 * statistics
 * 
 * @author Tsvetelin
 *
 */
public interface RaceStatistic
{

    /**
     * 
     * The name of the statistic
     * 
     * @return
     */
    public String getName ();

    /**
     * 
     * @return The coefficient that will be applied
     */
    public double getCoefficient ();

}
