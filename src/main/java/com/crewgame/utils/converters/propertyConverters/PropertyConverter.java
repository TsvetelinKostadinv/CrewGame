

/*
 * 04/09/2018 at 23:47:55
 * PropertyConverter.java created by Tsvetelin
 */
package com.crewgame.utils.converters.propertyConverters;

import java.lang.reflect.Method;

import com.crewgame.exceptions.UncastableException;
import com.crewgame.utils.converters.TypeConverter;
import com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;

/**
 * 
 * Converts from one property object to another. <br>
 * Note this object is not really needed because of the TypeConverter <br>
 *  and it's easy to use <code>convert</code> method
 * 
 * @author Tsvetelin
 *
 */
public class PropertyConverter extends TypeConverter
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    static {
        Method[] methods = PropertyConverter.class.getDeclaredMethods();
        for (Method method : methods) {
           addMethod( method );
        }
    }
    
    public AvailableResources toResource(Object prop) throws UncastableException
    {
        if(prop.getClass().equals( AvailableResources.class ))
        {
            return (AvailableResources) prop;
        }else {
            throw new UncastableException( "The supplied object cannot be cast" );
        }
    }
    
}
