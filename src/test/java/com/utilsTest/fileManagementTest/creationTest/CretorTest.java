

/*
 * 22/09/2018 at 18:40:43
 * CretorTest.java created by Tsvetelin
 */
package com.utilsTest.fileManagementTest.creationTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.utils.fileManagement.creation.Creator;
import com.utils.fileManagement.creation.IFileCreator;


/**
 * @author Tsvetelin
 *
 */
class CretorTest
{
    
    private static IFileCreator c;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        c = new Creator();
    }


    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        c = null;
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.creation.Creator#createDirectory(java.io.File)}.
     */
    @Test
    final void testCreateDirectoryFile ()
    {
        assertThrows( NullPointerException.class , ( ) -> c.createDirectory( (File) null ) );
        
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.creation.Creator#createDirectory(java.lang.String)}.
     */
    @Test
    final void testCreateDirectoryString ()
    {
        assertThrows( NullPointerException.class , ( ) -> c.createDirectory( (String) null ) );
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.creation.Creator#createFile(java.io.File)}.
     */
    @Test
    final void testCreateFileFile ()
    {
        assertThrows( NullPointerException.class , ( ) -> c.createFile( (File) null ));
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.creation.Creator#createFile(java.lang.String)}.
     */
    @Test
    final void testCreateFileString ()
    {
        assertThrows( NullPointerException.class , ( ) -> c.createFile( (String) null ));
    }

}
