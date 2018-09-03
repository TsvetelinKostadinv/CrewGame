

/*
 * 03/09/2018 at 16:53:28
 * WorldTileProperties.java created by Tsvetelin
 */
package com.crewgame.java.world.maps.worldTile.worldTileProperties;

import com.crewgame.java.world.maps.worldTile.worldTileProperties.resourceProperty.AvalilableResources;
import com.crewgame.java.world.resources.Resource;

/**
 * @author Tsvetelin
 *
 */
public class WorldTileProperties implements PropertyGameObject
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private AvalilableResources resources;
    
    
    /**
     * 
     */
    public WorldTileProperties ()
    {
        
    }

    /**
     * @return the resources
     */
    public AvalilableResources getResources ()
    {

        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources ( AvalilableResources resources )
    {

        this.resources = resources;
    }
    
    public static class Builder
    {
        private WorldTileProperties props = new WorldTileProperties();
        
        public Builder addResource(Resource res)
        {
            props.getResources().addResource( res );
            return this;
        }
        
        public WorldTileProperties build()
        {
            return props;
        }
        
    }
}
