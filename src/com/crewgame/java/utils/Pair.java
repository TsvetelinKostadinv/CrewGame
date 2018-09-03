

/*
 * 03/09/2018 at 14:43:29
 * Pair.java created by Tsvetelin
 */
package com.crewgame.java.utils;


/**
 * @author Tsvetelin
 *
 */
public class Pair < KeyType , ValueType >
{
    private KeyType key;
    private ValueType value;
    
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
     * @param key the key to set
     */
    public void setKey ( KeyType key )
    {

        this.key = key;
    }
    /**
     * @return the value
     */
    public ValueType getValue ()
    {

        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue ( ValueType value )
    {
        this.value = value;
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
