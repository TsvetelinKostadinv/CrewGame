

/*
 * 04/09/2018 at 23:41:58
 * TypeConverter.java created by Tsvetelin
 */
package com.crewgame.java.utils.converters;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Tsvetelin
 * @author BalusC - the original author of this code <br>
 * 
 *  NOTE: I took it and refactored it because it was old and I needed to adapt it to my own needs
 *
 */
public abstract class TypeConverter
{   

    // Init ---------------------------------------------------------------------------------------
    private static final Map<String, Method> CONVERTERS = new HashMap<String, Method>();
    

    // Action -------------------------------------------------------------------------------------
    /**
     * Convert the given object value to the given class.
     *
     * @param from The object value to be converted.
     * @param to The type class which the given object should be converted to.
     * @return The converted object value.
     * @throws NullPointerException If 'to' is null.
     * @throws UnsupportedOperationException If no suitable converter can be
     * found.
     * @throws RuntimeException If conversion failed somehow. This can be caused
     * by at least an ExceptionInInitializerError, IllegalAccessException or
     * InvocationTargetException.
     */
    public static <T> T convert(Object from, Class<T> to) {

        // Null is just null.
        if (from == null) {
            return null;
        }

        // Can we cast? Then just do it.
        if (to.isAssignableFrom(from.getClass())) {
            return to.cast(from);
        }

        // Lookup the suitable converter.
        String converterId = from.getClass().getName() + "_" + to.getName();
        Method converter = getConverters().get(converterId);
        if (converter == null) {
            throw new UnsupportedOperationException("Cannot convert from "
                    + from.getClass().getName() + " to " + to.getName()
                    + ". Requested converter does not exist.");
        }

        // Convert the value.
        try {
            return to.cast(converter.invoke(to, from));
        } catch (Exception e) {
            throw new RuntimeException("Cannot convert from "
                    + from.getClass().getName() + " to " + to.getName()
                    + ". Conversion failed with " + e.getMessage(), e);
        }
    }


    /**
     * @return the converters
     */
    public static Map<String, Method> getConverters ()
    {

        return CONVERTERS;
    }
    
}
