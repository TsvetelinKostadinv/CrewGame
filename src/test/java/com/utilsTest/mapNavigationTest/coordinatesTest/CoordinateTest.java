

/*
 * 23/09/2018 at 18:07:50
 * CoordinateTest.java created by Tsvetelin
 */
package com.utilsTest.mapNavigationTest.coordinatesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.utils.mapNavigation.coordinates.Coordinate;


/**
 * @author Tsvetelin
 *
 */
class CoordinateTest
{
    
    private static Coordinate coord00;
    private static Coordinate coord10;
    private static Coordinate coord01;
    private static Coordinate coord11;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass () throws Exception
    {
        coord00 = new Coordinate(0, 0);
        coord01 = new Coordinate( 0 , 1 );
        coord10 = new Coordinate( 1 , 0 );
        coord11 = new Coordinate( 1 , 1 );
    }


    /**
     * @throws java.lang.Exception
     */
    @AfterAll
    static void tearDownAfterClass () throws Exception
    {
        coord00 = null;
        coord01 = null;
        coord10 = null;
        coord11 = null;
    }


    /**
     * Test method for {@link com.utilsTest.mapNavigation.coordinates.Coordinate#compareTo(com.utilsTest.mapNavigation.coordinates.Coordinate)}.
     */
    @Test
    final void testCompareTo ()
    {
        assertEquals( 0 , coord00.compareTo( coord00 ) , "Expected to be equal" );
        assertEquals( 0 , coord01.compareTo( coord01 ) , "Expected to be equal" );
        assertEquals( 0 , coord10.compareTo( coord10 ) , "Expected to be equal" );
        assertEquals( 0 , coord11.compareTo( coord11 ) , "Expected to be equal" );
        
        assertEquals( -1 , coord00.compareTo( coord01 ) , "Expected to be greater" );
        assertEquals( -1 , coord00.compareTo( coord10 ) , "Expected to be greater" );
        assertEquals( -1 , coord00.compareTo( coord11 ) , "Expected to be greater" );
        assertEquals( -1 , coord00.compareTo( coord01 ) , "Expected to be greater" );
        
        assertEquals( -1 , coord01.compareTo( coord10 ) , "Expected to be greater" );
        assertEquals( -1 , coord01.compareTo( coord11 ) , "Expected to be greater" );
        
        assertEquals( -1 , coord10.compareTo( coord11 ) , "Expected to be greater" );
        
        assertEquals( 1 , coord11.compareTo( coord00 ) , "Expected to be less" );
        assertEquals( 1 , coord11.compareTo( coord01 ) , "Expected to be less" );
        assertEquals( 1 , coord11.compareTo( coord10 ) , "Expected to be less" );
        
        assertEquals( 1 , coord10.compareTo( coord00 ) , "Expected to be less" );
        assertEquals( 1 , coord10.compareTo( coord01 ) , "Expected to be less" );
        
        assertEquals( 1 , coord01.compareTo( coord00 ) , "Expected to be less" );
    }

}
