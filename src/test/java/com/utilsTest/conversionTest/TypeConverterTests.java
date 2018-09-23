

/*
 * 17/09/2018 at 23:59:07
 * Conv.java created by Tsvetelin
 */
package com.utilsTest.conversionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.world.resources.Resource;
import com.utils.converters.TypeConverter;


/**
 * @author Tsvetelin
 *
 */
class TypeConverterTests
{
    
    @Test
    final void nullNullTest ()
    {
        if(TypeConverter.convert( null , null ) != null) fail("Expected null");
    }
    
    @Test
    final void realNullTest ()
    {
        if(TypeConverter.convert( new Object() , null ) != null) fail("Expected null");
    }
    
    @Test
    final void nullRealSuperTypeTest ()
    {
        if(TypeConverter.convert( null , Object.class ) != null) fail("Expected null");
    }
    
    @Test
    final void nullRealConcreteTypeTest ()
    {
        if(TypeConverter.convert( null , Resource.class ) != null) fail("Expected null"); 
    }
    
    @Test
    final void objectNotImplementedTypeTest ()
    {
        try
        {
            TypeConverter.convert( new Object() , Integer.class );
            fail("Did NOT throw an exception");
        } catch ( UnsupportedOperationException e )
        {
            //test passes
        }
    }
    
    @Test
    final void realToSupertypeTest()
    {
        Resource res = new Resource("wood", 100)
        { private static final long serialVersionUID = 1L; };
        
        if(!TypeConverter.convert( res , Object.class ).equals( res )) fail("Expected to be equal");
    }
    
    @Test
    final void objectToConcreteClass()
    {
        Object res = new Resource("wood", 100)
        { private static final long serialVersionUID = 1L; };
        
        if(! ( TypeConverter.convert( res , Resource.class ) instanceof Resource )) fail("Expected to be instance");
    }
    
    @Test
    final void objectToUncastableConcreteClass()
    {
        Object res = new Resource("wood", 100)
        { private static final long serialVersionUID = 1L; };
        
        assertThrows(UnsupportedOperationException.class,
                () -> { TypeConverter.convert( res , AvailableResources.class ); } );
    }
    
}
