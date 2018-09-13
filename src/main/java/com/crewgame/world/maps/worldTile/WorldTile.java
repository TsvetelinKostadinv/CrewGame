

/*
 * 31/08/2018 at 14:15:24
 * WorldTile.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile;

import com.crewgame.world.WorldGameObject;
import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperties;

/**
 * 
 * This class represents a single world tile from the whole game map
 * 
 * @author Tsvetelin
 *
 */
public class WorldTile implements WorldGameObject
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    private WorldTileProperties props;



    /**
     * @param resources
     */
    public WorldTile ( WorldTileProperties props )
    {

        super();
        this.props = props;
    }
    
    /**
     * @param resources the resources to set
     */
    public void setProperties ( WorldTileProperties props )
    {

        this.props = props;
    }

    /**
     * @return the resources
     */
    public WorldTileProperties getProperties ()
    {
        return props;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "This is world tile with properties" + System.lineSeparator() +props.toString();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals ( Object obj )
    {
        return (obj instanceof WorldTile) && ( (WorldTile) obj ).props.equals( this.props );
    }
    

}
