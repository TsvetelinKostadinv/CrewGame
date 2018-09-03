

/*
 * 31/08/2018 at 14:15:24
 * WorldTile.java created by Tsvetelin
 */
package com.crewgame.java.world.maps;

import com.crewgame.java.world.WorldGameObject;
import com.crewgame.java.world.maps.worldTileProperties.WorldTileProperties;

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
     * @param props
     */
    public WorldTile ( WorldTileProperties props )
    {

        super();
        this.props = props;
    }


    /**
     * @return the props
     */
    public WorldTileProperties getProps ()
    {

        return props;
    }


    /**
     * @param props the props to set
     */
    public void setProps ( WorldTileProperties props )
    {

        this.props = props;
    }
    
    
}
