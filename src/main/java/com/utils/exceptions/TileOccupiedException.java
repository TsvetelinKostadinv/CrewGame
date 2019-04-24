

/*
 * 09/09/2018 at 22:10:37
 * TileOccupiedException.java created by Tsvetelin
 */
package com.utils.exceptions;


/**
 * @author Tsvetelin
 *
 */
public final class TileOccupiedException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public TileOccupiedException ()
    {

        super();
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public TileOccupiedException ( String message , Throwable cause , boolean enableSuppression ,
            boolean writableStackTrace )
    {

        super( message , cause , enableSuppression , writableStackTrace );
    }

    /**
     * @param message
     * @param cause
     */
    public TileOccupiedException ( String message , Throwable cause )
    {

        super( message , cause );
    }

    /**
     * @param message
     */
    public TileOccupiedException ( String message )
    {

        super( message );
    }

    /**
     * @param cause
     */
    public TileOccupiedException ( Throwable cause )
    {

        super( cause );
    }
    
    
    

}
