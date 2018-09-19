

/*
 * 04/09/2018 at 23:47:55
 * PropertyConverter.java created by Tsvetelin
 */
package com.utils.converters.propertyConverters;

import java.lang.reflect.Method;

import com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.world.resources.Resource;
import com.utils.converters.TypeConverter;

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
    
    public AvailableResources toAvailableResources(Object prop)
    {
        if(prop.getClass().equals( AvailableResources.class ))
        {
            return (AvailableResources) prop;
        }
        return null;
    }
    
    public Resource toResource(Object prop)
    {
        if(prop.getClass().equals( Resource.class ))
        {
            return (Resource) prop;
        }
        return null;
    }
}
