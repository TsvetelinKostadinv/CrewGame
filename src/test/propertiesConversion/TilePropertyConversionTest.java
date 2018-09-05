

/*
 * 05/09/2018 at 16:44:43
 * Test.java created by Tsvetelin
 */
package test.propertiesConversion;

import com.crewgame.java.utils.converters.TypeConverter;
import com.crewgame.java.world.maps.worldTile.WorldTile;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.WorldTileProperties;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.WorldTileProperty;
import com.crewgame.java.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.java.world.resources.Resource;

/**
 * @author Tsvetelin
 *
 */
public class TilePropertyConversionTest
{
    
    public static void main ( String [] args )
    {
        WorldTileProperties props = new WorldTileProperties();
        
        Resource res1 = new Resource("wood", 100) { private static final long serialVersionUID = 1L; };
        Resource res2 = new Resource("iron", 1234) { private static final long serialVersionUID = 1L; };
        Resource res3 = new Resource("stone", 666) { private static final long serialVersionUID = 1L; };
        Resource res4 = new Resource("gold", 123456789) { private static final long serialVersionUID = 1L; };
        
        
        AvailableResources reses = new AvailableResources(res1, res2, res3, res4);
        
        boolean flag = reses.getClass().isAnnotationPresent( WorldTileProperty.class );
        System.out.println( "Does it have annotation: " + flag );
        
        props.addProperty( reses );
        
        WorldTile tile = new WorldTile( props );
        
        Object obj = tile.getProperties().getUncastedProperyAt( 0 );
        
        AvailableResources reses2 = TypeConverter.convert( obj , AvailableResources.class );
        System.out.println( reses2 );
        
    }
}
