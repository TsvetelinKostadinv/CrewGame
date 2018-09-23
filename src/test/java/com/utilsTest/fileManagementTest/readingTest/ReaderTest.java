

/*
 * 23/09/2018 at 16:56:33
 * ReaderTest.java created by Tsvetelin
 */
package com.utilsTest.fileManagementTest.readingTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;

import com.utils.fileManagement.reading.IFileReader;
import com.utils.fileManagement.reading.Reader;
import com.utils.fileManagement.writing.IFileWriter;
import com.utils.fileManagement.writing.Writer;


/**
 * @author Tsvetelin
 *
 */
class ReaderTest
{
    
    private static IFileReader reader;
    
    private static TemporaryFolder testFolder;
    private static File testFileSingleLine;
    private static File testFileMultiLine;
    
    private static final String testFileSingleLineName = "singleLine.txt";
    private static final String testFileMultiLineName = "multiLine.txt";
    
    private static final String testStringSingleLine = "Test String";
    private static final String testStringMultiLine = constructMultiLineTestString();
    
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        reader = new Reader();
        
        testFolder = new TemporaryFolder();
        testFolder.create();
        
        testFileSingleLine = testFolder.newFile( testFileSingleLineName );
        testFileMultiLine = testFolder.newFile( testFileMultiLineName );
        
        IFileWriter writer = new Writer();
        
        writer.writeToFile( testFileSingleLine , testStringSingleLine , true );
        writer.writeToFile( testFileMultiLine , testStringMultiLine , true );
    }
    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        reader = null;
        testFolder.delete();
        testFolder = null;
        testFileSingleLine = null;
        testFileMultiLine = null;
    }
    
    /**
     * @return
     */
    private static String constructMultiLineTestString ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( testStringSingleLine );
        sb.append( System.lineSeparator() );
        sb.append( "Second line" );
        return sb.toString();
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.reading.Reader#readFile(java.io.File)}.
     * @throws IOException 
     */
    @Test
    final void testReadFileFile () throws IOException
    {
        assertThrows( NullPointerException.class , 
                ( ) -> reader.readFile( (File) null ), 
                "After calling on the null object it did NOT throw an exception");
        
        assertEquals( testStringMultiLine + System.lineSeparator() , 
                reader.readFile( testFileMultiLine ) , 
                "After reading the whole file with multiple line they did NOT match"  );
        assertEquals( testStringSingleLine + System.lineSeparator() , 
                reader.readFile( testFileSingleLine ) , 
                "After reading the whole file with a single line they did NOT match");
    }

    /**
     * Test method for {@link com.utilsTest.fileManagement.reading.Reader#readLineFromFile(java.io.File, int)}.
     * @throws IOException 
     */
    @SuppressWarnings ( "null" )
    @Test
    final void testReadLineFromFileFileInt () throws IOException
    {
        
        assertThrows( NullPointerException.class , 
                ( ) -> reader.readLineFromFile( (File) null , (Integer) null ),
                "After calling on the null object it did NOT throw an exception");
        
        assertThrows( NullPointerException.class ,
                ( ) -> reader.readLineFromFile( (File) null , 0 ),
                "After calling on the null object it did NOT throw an exception");
        
        assertThrows( IllegalArgumentException.class , 
                ( ) -> reader.readLineFromFile( testFileSingleLine , -1 ), 
                "After calling with an negative line number it did NOT throw an exception");
        
        assertEquals( testStringSingleLine ,
                reader.readLineFromFile( testFileMultiLine , 1 ),
                "Reading from a multiline text file the lines did NOT match");
        assertEquals( testStringSingleLine , reader.readLineFromFile( testFileSingleLine , 1 ),
                "Reading from a single line text file the line did NOT match" );
    }

}
