

/*
 * 05/09/2018 at 22:42:42
 * Serializer.java created by Tsvetelin
 */
package com.crewgame.java.utils.saving.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.crewgame.java.base.BaseGameObject;
import com.crewgame.java.utils.saving.Saver;

/**
 * @author Tsvetelin
 *
 */
public class Serializer implements Saver
{
    private ObjectOutputStream out;

    /* (non-Javadoc)
     * @see com.crewgame.java.utils.saving.Saver#save(java.io.File, com.crewgame.java.base.BaseGameObject)
     */
    @Override
    public < T extends BaseGameObject > void save ( File location , T save )
    {
        if(location != null)
        {
            try
            {
                out = new ObjectOutputStream( new FileOutputStream(location) );
                out.writeObject( save );
                out.close();
            } catch ( IOException e )
            {
                System.out.println( "IO exception occured" );
            }finally {
                out = null;
            }
        }
    }
    
}
