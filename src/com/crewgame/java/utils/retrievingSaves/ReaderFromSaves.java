

/*
 * 05/09/2018 at 23:38:30
 * ReadFromSave.java created by Tsvetelin
 */
package com.crewgame.java.utils.retrievingSaves;

import java.io.File;

/**
 * @author Tsvetelin
 *
 */
public interface ReaderFromSaves
{
    public < T > T readFromSave(File location, Class<T> desiredObject);
}
