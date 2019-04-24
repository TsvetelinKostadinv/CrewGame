

/*
 * 31/08/2018 at 14:16:59
 * Resource.java created by Tsvetelin
 */
package com.crewgame.world.resources;

/**
 * 
 * This class represents a simple resource. However it can be extended in order to add functionality.
 * 
 * @author Tsvetelin
 *
 */
public /* abstract */ class Resource implements ResourceGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private final String name;
    private final long amount;
    
    
    /**
     * 
     */
    public Resource (String name, long amount)
    {
        this.name = name;
        this.amount = amount;
    }
    
    
    /**
     * 
     * @return the name of the resource
     */
    public String getName (  )
    {
        return this.name;
    }
    
    /**
     * 
     * @return the amount of the resource
     */
    public long getAmount(  )
    {
        return this.amount;
    }
    
    /**
     * 
     * 
     * @param newAmmount - the new amount to be assigned
     */
    public Resource setAmount( long newAmmount )
    {
        return new Resource( this.name , newAmmount );
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        
        return "Resource: " + name + " with " + amount + " points available";
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        boolean sameName = ((Resource) obj).name.equals( this.name );
        boolean sameAmount = ((Resource) obj).amount == this.amount;
        return sameName && sameAmount;
    }
    
}
