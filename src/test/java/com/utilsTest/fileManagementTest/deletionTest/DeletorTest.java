

/*
 * 23/09/2018 at 16:48:01
 * DeletorTest.java created by Tsvetelin
 */
package com.utilsTest.fileManagementTest.deletionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.utils.fileManagement.deletion.Deletor;
import com.utils.fileManagement.deletion.IFileDeletor;


/**
 * @author Tsvetelin
 *
 */
class DeletorTest
{
    
    private static IFileDeletor del;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        del = new Deletor();
    }


    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        del = null;
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.deletion.Deletor#delete(java.io.File)}.
     */
    @Test
    final void testDeleteFile ()
    {

        assertThrows( NullPointerException.class , ( ) -> del.delete( (File)null ));
    }


    /**
     * Test method for {@link com.utilsTest.fileManagement.deletion.Deletor#delete(java.lang.String)}.
     */
    @Test
    final void testDeleteString ()
    {

        assertThrows( NullPointerException.class , ( ) -> del.delete( (String)null ));
    }

}
