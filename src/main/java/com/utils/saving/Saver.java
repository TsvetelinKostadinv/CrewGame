

/*
 * 05/09/2018 at 23:30:55
 * Saver.java created by Tsvetelin
 */
package com.utils.saving;

import java.io.File;
import java.io.Serializable;

/**
 * 
 * Simple interface for saving data to a file with a supplied object
 * 
 * @author Tsvetelin
 *
 */
@FunctionalInterface
public interface Saver
{
    /**
     * 
     * Saves the supplied object to the location
     * 
     * @param location
     * @param save
     */
    public < T extends Serializable > void save(File location, T save);

}
