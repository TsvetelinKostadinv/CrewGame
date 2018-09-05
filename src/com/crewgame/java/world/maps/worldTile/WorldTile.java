

/*
 * 31/08/2018 at 14:15:24
 * WorldTile.java created by Tsvetelin
 */
package com.crewgame.java.world.maps.worldTile;

import com.crewgame.java.world.WorldGameObject;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.WorldTileProperties;

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

}
