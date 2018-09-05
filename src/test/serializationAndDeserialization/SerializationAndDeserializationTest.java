

/*
 * 05/09/2018 at 23:26:09
 * SerializationAndDeserializationTest.java created by Tsvetelin
 */
package test.serializationAndDeserialization;


import java.io.File;

import com.crewgame.java.utils.retrievingSaves.deserialization.Deserializer;
import com.crewgame.java.utils.saving.serialization.Serializer;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.java.world.resources.Resource;


/**
 * @author Tsvetelin
 *
 */
public class SerializationAndDeserializationTest
{

    public static void main ( String [] args ) throws Exception
    {

        Serializer ser = new Serializer();
        Deserializer deser = new Deserializer();
        File loc = new File( "test/test.ser" );

        new File( loc.getParent() ).mkdirs();
        loc.createNewFile();

        Resource res1 = new Resource( "wood" , 100 )
        {

            private static final long serialVersionUID = 1L;
        };
        Resource res2 = new Resource( "iron" , 100 )
        {

            private static final long serialVersionUID = 1L;
        };
        Resource res3 = new Resource( "stone" , 100 )
        {

            private static final long serialVersionUID = 1L;
        };
        Resource res4 = new Resource( "gold" , 100 )
        {

            private static final long serialVersionUID = 1L;
        };

        ser.save( loc , new AvailableResources( res1 , res2 , res3 , res4 ) );

        AvailableResources reses = deser.readFromSave( loc , AvailableResources.class );

        System.out.println( reses );

    }
}
