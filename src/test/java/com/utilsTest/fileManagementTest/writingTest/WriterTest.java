

/*
 * 23/09/2018 at 17:43:05
 * WriterTest.java created by Tsvetelin
 */
package com.utilsTest.fileManagementTest.writingTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import com.utils.fileManagement.reading.Reader;
import com.utils.fileManagement.writing.IFileWriter;
import com.utils.fileManagement.writing.Writer;


/**
 * @author Tsvetelin
 *
 */
class WriterTest
{
    
    private static TemporaryFolder tempFolder;
    private static File tempFile;
    
    private static String testFileName = "test.txt";
    private static String writingFirstLine = "First line";
    private static String writingSecondLine = "Second line";
    private static IFileWriter writer;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        writer = new Writer();
        
        tempFolder = new TemporaryFolder();
        tempFolder.create();
        tempFile = tempFolder.newFile( testFileName );
    }


    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        writer = null;
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.writing.Writer#writeToFile(java.io.File, java.lang.String, boolean)}.
     * @throws IOException 
     */
    @Test
    final void testWriteToFileFileStringBoolean () throws IOException
    {
        assertThrows( NullPointerException.class ,
                ( ) -> writer.writeToFile( (File) null , null , true ) , 
                "After calling on a null file it did NOT throw a exception");
        
        writer.writeToFile( tempFile , writingFirstLine , true );
        assertEquals( writingFirstLine + System.lineSeparator() ,
                new Reader().readFile( tempFile ), 
                "Expected only the first line to be written" );
        
        writer.writeToFile( tempFile , writingSecondLine , false );
        assertEquals( writingSecondLine + System.lineSeparator() ,
                new Reader().readFile( tempFile ), 
                "Expected the lines to be overwritten" );
        
        
        writer.writeToFile( tempFile , writingFirstLine , false );
        writer.writeToFile( tempFile , System.lineSeparator() , true );
        writer.writeToFile( tempFile , writingSecondLine , true );
        assertEquals( writingFirstLine + System.lineSeparator() + writingSecondLine + System.lineSeparator(),
                new Reader().readFile( tempFile ), 
                "Expected the lines to be overwritten" );
    }

}
