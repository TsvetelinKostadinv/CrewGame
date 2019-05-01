
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
@FunctionalInterface
public interface LocalMapGenerator
{

    public LocalMap generate ();

    public static LocalMap generateSample ()
    {
        LocalMap local = LocalMap.EMPTY_LOCAL_MAP;

        while ( !local.isFull() )
        {
            local
                    .addOnNextAvailableCorrdinate(
                            WorldTileGenerator.generateSample() );
        }

        return local;
    }

    public static void main ( String [] args )
    {
        System.out.println( LocalMapGenerator.generateSample().toString() );
    }
}
