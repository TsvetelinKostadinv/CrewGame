

/*
 * 03/09/2018 at 17:48:41
 * Coordinate.java created by Tsvetelin
 */
package com.crewgame.java.utils.mapNavigation;

import com.crewgame.java.utils.UtilityGameObject;

/**
 * 
 * This is a utility class for storing simple coordinates
 * 
 * @author Tsvetelin
 *
 */
public final class Coordinate implements UtilityGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private long x;
    private long y;
    

    /**
     * @param x
     * @param y
     */
    public Coordinate ( long x , long y )
    {

        super();
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public long getX ()
    {

        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX ( long x )
    {

        this.x = x;
    }

    /**
     * @return the y
     */
    public long getY ()
    {

        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY ( long y )
    {

        this.y = y;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
    
        return "x = " + x + ", y = " + y;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return obj instanceof Coordinate ? ( (Coordinate) obj).x == this.x && ( (Coordinate) obj).y == this.y : false;
    }

}
