

/*
 * 23/09/2018 at 18:27:13
 * SerializationDeserializationTest.java created by Tsvetelin
 */
package com.utilsTest.SerializationDeserializationTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.world.resources.Resource;
import com.utils.retrievingSaves.ReaderFromSaves;
import com.utils.retrievingSaves.deserialization.Deserializer;
import com.utils.saving.Saver;
import com.utils.saving.serialization.Serializer;


/**
 * @author Tsvetelin
 *
 */
class SerializationDeserializationTest
{
    
    static TemporaryFolder tempFolder;
    static File tempFile;
    static ReaderFromSaves reader;
    static Saver saver;
    
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        tempFolder = new TemporaryFolder();
        tempFolder.create();
        tempFile = tempFolder.newFile("save.ser");
        
        saver = new Serializer();
        reader = new Deserializer();
    }


    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        tempFolder.delete();
        saver = null;
        reader = null;
    }


    @Test
    final void test () throws IOException
    {
        File save  = new File( "src/test/java/test.txt" );
        
        save.createNewFile();
        
        Resource wood = new Resource("wood", 100);
        Resource stone = new Resource("stone", 1000);
        Resource gold = new Resource("gold", 900);
        Resource iron = new Resource("iron", 123);
        
        AvailableResources resesForSerialization = AvailableResources.empty().addResource( iron ).addResource( gold ).addResource( stone ).addResource( wood );
        
        saver.save( tempFile , resesForSerialization );
        
        AvailableResources deserReses = ( reader.readFromSave( tempFile , AvailableResources.class ));
        
        System.out.println( deserReses );
        
        assertEquals( resesForSerialization , deserReses );
        
    }

}
