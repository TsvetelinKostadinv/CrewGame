
/*
 * 05/09/2018 at 23:38:30
 * ReadFromSave.java created by Tsvetelin
 */
package com.utils.retrievingSaves;


import java.io.File;
import java.util.Optional;


/**
 * 
 * Simple interface for retrieving and parsing data from a file
 * 
 * @author Tsvetelin
 *
 */
@FunctionalInterface
public interface ReaderFromSaves
{

    /**
     * 
     * Reads the file and then parses it to the supplied <code>Class</code>
     * object and returns and optional of it
     * 
     * @param location
     * @param desiredObject
     */
    public < T > Optional< T > readFromSave (
            File location ,
            Class< T > desiredObject );
}
