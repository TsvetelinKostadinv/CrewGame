

/*
 * 04/09/2018 at 23:47:55
 * PropertyConverter.java created by Tsvetelin
 */
package com.crewgame.java.utils.converters.propertyConverters;

import java.lang.reflect.Method;

import com.crewgame.java.exceptions.UncastableException;
import com.crewgame.java.utils.converters.TypeConverter;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;

/**
 * @author Tsvetelin
 *
 */
public class PropertyConverter extends TypeConverter
{
    static {
        Method[] methods = PropertyConverter.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterTypes().length == 1) {
                getConverters().put(method.getParameterTypes()[0].getName() + "_"
                        + method.getReturnType().getName(), method);
            }
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
