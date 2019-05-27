
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

    public static LocalMap generate (
            final WorldTileGenerator generator ,
            final int xSize ,
            final int ySize )
    {
        System.out.println( "Generating..." );
        LocalMap local = LocalMap.create( xSize , ySize );

        while ( !local.isFull() )
        {
            local
                    .addOnNextAvailableCorrdinate(
                            generator.generateTile() );
        }

        return local;

    }

    public static LocalMap mock ()
    {
        return generate(
                WorldTileGenerator::mock ,
                LocalMap.DEFAULT_X_RANGE ,
                LocalMap.DEFAULT_Y_RANGE );
    }
    
}
