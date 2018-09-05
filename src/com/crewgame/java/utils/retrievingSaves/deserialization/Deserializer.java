

/*
 * 05/09/2018 at 23:06:58
 * Deserializer.java created by Tsvetelin
 */
package com.crewgame.java.utils.retrievingSaves.deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.crewgame.java.utils.converters.TypeConverter;
import com.crewgame.java.utils.retrievingSaves.ReaderFromSaves;

/**
 * @author Tsvetelin
 *
 */
public class Deserializer implements ReaderFromSaves
{
    private ObjectInputStream in;

    /* (non-Javadoc)
     * @see com.crewgame.java.utils.retrievingSaves.ReaderFromSaves#readFromSave(java.io.File, java.lang.Class)
     */
    @Override
    public < T > T readFromSave ( File location , Class< T > desiredObject )
    {
        Object readObj = null;
        try
        {
            in = new ObjectInputStream( new FileInputStream( location ) );
            readObj = in.readObject();
            in.close();
        } catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( ClassNotFoundException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        in = null;
        return TypeConverter.convert( readObj , desiredObject );
    }
    
   
}
