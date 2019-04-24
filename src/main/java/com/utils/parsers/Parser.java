

/*
 * 03/09/2018 at 18:08:44
 * Parser.java created by Tsvetelin
 */
package com.utils.parsers;

/**
 * 
 * Parses the data from a object of the supplied <code>Type</code>
 * 
 * @author Tsvetelin
 *
 * @param <Type> - the return type of the parsing function
 */
@FunctionalInterface
public interface Parser < From , To >
{
    
    /**
     * 
     * Parses the values in the given file to the <code>Type</code> object
     * 
     * @param save - the file to be read
     * @return a list of all the parsed objects or null if it cannot be parsed
     */
    public To parse(From save);
    
}
