
/*
 * 01/05/2019 at 13:17:53 ÷.
 * LocalMapGenerator.java created by Tsvetelin
 */
package com.crewgame.world.util.generators.localMapGenerator;


import com.crewgame.world.maps.localMap.LocalMap;
import com.crewgame.world.util.generators.worldTile.WorldTileGenerator;


/**
 * @author Tsvetelin
 *
 */
public interface LocalMapGenerator
{

    public static LocalMap generate ( final WorldTileGenerator generator , final int xSize , final int ySize )
    {
        System.out.println( "Generating..." );
        LocalMap local = LocalMap.create( xSize , ySize );
        
        
        do{
            local
                    .addOnNextAvailableCorrdinate(
                            generator.generateTile() );
        }while ( !local.isFull() );

        return local;
        
    }

    public static LocalMap mock ()
    {
        LocalMap local = LocalMap.EMPTY_DEFAULT_LOCAL_MAP;

        while ( !local.isFull() )
        {
            local
                    .addOnNextAvailableCorrdinate(
                            WorldTileGenerator.mock() );
        }

        return local;
    }
}
