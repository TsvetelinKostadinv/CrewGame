

/*
 * 05/09/2018 at 0:43:31
 * UncastableException.java created by Tsvetelin
 */
package com.crewgame.java.exceptions;


/**
 * 
 * This exception is thrown when a cast is attempted and it was not successful
 * 
 * @author Tsvetelin
 *
 */
public class UncastableException extends Exception
{

    /**
     * @param string
     */
    public UncastableException ( String string )
    {
        super(string);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
