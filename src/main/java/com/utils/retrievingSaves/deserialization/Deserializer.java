
/*
 * 05/09/2018 at 23:06:58
 * Deserializer.java created by Tsvetelin
 */
package com.utils.retrievingSaves.deserialization;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

import com.utils.retrievingSaves.ReaderFromSaves;


/**
 * 
 * A standard one-method utility class for deserializing data from a .ser file
 * 
 * @author Tsvetelin
 *
 */
public class Deserializer implements ReaderFromSaves
{

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.utilsTest.retrievingSaves.ReaderFromSaves#readFromSave(java.io.File,
     * java.lang.Class)
     */
    @Override
    public < T > Optional< T > readFromSave (
            File location ,
            Class< T > desiredObject )
    {
        Object readObj = null;
        try
        {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream( location ) );
            readObj = in.readObject();
            in.close();
        } catch ( IOException e )
        {
            e.printStackTrace();
        } catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }

        try
        {
            return Optional.of( desiredObject.cast( readObj ) );
        } catch ( ClassCastException e )
        {
            return Optional.empty();
        }
    }

}
