

/*
 * 03/09/2018 at 14:43:29
 * Pair.java created by Tsvetelin
 */
package com.utils;


/**
 * 
 * Simple utility class for storing a Key/Value pair
 * 
 * @author Tsvetelin
 *
 */
public class Pair < KeyType , ValueType >
{
    private final KeyType key;
    private final ValueType value;
    
    public static final Pair< ? , ? > IDENTITY = new Pair<>( null, null );
    
    /**
     * @param key
     * @param value
     */
    public Pair ( KeyType key , ValueType value )
    {

        super();
        this.key = key;
        this.value = value;
    }
    
    /**
     * @return the key
     */
    public KeyType getKey ()
    {

        return key;
    }
    /**
     * @return the value
     */
    public ValueType getValue ()
    {

        return value;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "Key/Value pair containing " + key.toString() + " of type " + key.getClass() + " as a key" +
                " and " + value.toString() + " of type " + value.getClass() + "as a value";
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        boolean sameKey = ((Pair< ? , ? >) obj).getKey().equals( this.key );
        boolean sameValue = ((Pair< ? , ? >) obj).getValue().equals( this.value );
        return sameKey && sameValue;
    }
}
