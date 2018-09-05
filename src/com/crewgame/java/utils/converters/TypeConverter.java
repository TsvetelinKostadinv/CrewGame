

/*
 * 04/09/2018 at 23:41:58
 * TypeConverter.java created by Tsvetelin
 */
package com.crewgame.java.utils.converters;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.crewgame.java.utils.UtilityGameObject;


/**
 * 
 * The all-you-need converter   <br>
 * If it cannot parse you can create a custom method and add it  to the list    <br>
 * This class allows to pseudo dynamically change the runtime type of an object 
 * 
 * @author Tsvetelin
 * @author BalusC - the original author of this code <br>
 * 
 *  NOTE: I took it and refactored it because it was old and I needed to adapt it to my own needs
 *
 */
public abstract class TypeConverter implements UtilityGameObject
{   

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
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
        Method converter = CONVERTERS.get(converterId);
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
     * 
     * This is the correct method if you want to add custom parsers to the list.    <br>
     * The name is automatically generated and added for much easier access
     * 
     * @param method
     */
    public static void addMethod(Method method)
    {
        if (method.getParameterTypes().length == 1 && !CONVERTERS.containsValue( method )) 
        {
            String genName = method.getParameterTypes()[0].getName() + "_" + method.getReturnType().getName();
            CONVERTERS.put( genName, method);
        }else {
            throw new IllegalArgumentException("The supplied method should be uniqe to the list "
                                                        + "and must have only one input parameter");
        }
    }
    
}
