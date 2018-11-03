

/*
 * 05/09/2018 at 22:42:42
 * Serializer.java created by Tsvetelin
 */
package com.utils.saving.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.crewgame.base.BaseGameObject;
import com.utils.saving.Saver;

/**
 * 
 * Simple implementation of the <code>Saver</code> interface employing the <code>Serializable</code>
 * 
 * @author Tsvetelin
 *
 */
public class Serializer implements Saver
{
    private ObjectOutputStream out;

    /* (non-Javadoc)
     * @see com.utilsTest.saving.Saver#save(java.io.File, com.crewgame.base.BaseGameObject)
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
                e.printStackTrace();
            }finally {
                out = null;
            }
        }
    }
    
    public < T extends BaseGameObject > void printSerializedObject(T save)
    {
        try
        {
            out = new ObjectOutputStream( System.out );
            out.writeObject( save );
        } catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}