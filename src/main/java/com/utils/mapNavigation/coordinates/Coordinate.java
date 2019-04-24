

/*
 * 03/09/2018 at 17:48:41
 * Coordinate.java created by Tsvetelin
 */
package com.utils.mapNavigation.coordinates;

import java.util.Comparator;

/**
 * 
 * This is a utility class for storing simple coordinates
 * 
 * @author Tsvetelin
 *
 */
public final class Coordinate implements Comparable< Coordinate >
{
    public static final Comparator< Coordinate > COORDINATE_COMPARATOR = ( coord1 , coord2 ) -> coord1.compareTo( coord2 );
    
    public static final Coordinate ORIGIN = new Coordinate( 0 , 0 );
    
    private final long x;
    private final long y;
    


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
    
    public Coordinate xy( long x , long y)
    {
        return new Coordinate( x , y );
    }
    
    public Coordinate x(long x)
    {
        return new Coordinate( x , this.y );
    }
    
    public Coordinate y(long y)
    {
        return new Coordinate( this.x , y );
    }

    /**
     * @return the x
     */
    public long getX ()
    {

        return x;
    }

    /**
     * @return the y
     */
    public long getY ()
    {

        return y;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo ( Coordinate o )
    {
        if( this.equals( o ) ) return 0;
        if( this.getX() == o.getX() ) return (this.getY() > o.getY() ? 1 : -1) ;
        if( this.getX() > o.getX()) return 1;
        
        return -1;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
    
        return String.format( "[x := %d , y := %d]" , x , y );
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
