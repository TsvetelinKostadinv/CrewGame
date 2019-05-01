
/*
 * 01/05/2019 at 12:40:55 ÷.
 * WorldTileGenerator.java created by Tsvetelin
 */
package com.crewgame.world.util.generators.worldTile;


import java.util.Random;

import com.crewgame.world.maps.worldTile.WorldTile;
import com.crewgame.world.maps.worldTile.worldTileProperties.WorldTileProperties;
import com.crewgame.world.maps.worldTile.worldTileProperties.resourceProperty.AvailableResources;
import com.crewgame.world.resources.Resource;


/**
 * 
 * Generator for a <code>WorldTile</code> object
 * 
 * @author Tsvetelin
 *
 */
public interface WorldTileGenerator
{

    public static enum SampleResources
    {
        WOOD (
                "Wood" ,
                1_000_000
        ) ,
        STONE (
                "Stone" ,
                5_000_000
        ) ,
        IRON (
                "Iron" ,
                50_000
        ) ,
        GOLD (
                "Gold" ,
                5_000
        );

        public final String name;

        public final long   value;

        private SampleResources ( String name , long value )
        {
            this.name = name;
            this.value = value;
        }

        protected Resource toResource ()
        {
            Random r = new Random();
            return new Resource( this.name , Math.round( this.value * r.nextInt( 21 )/10 ) );
        }
    }

    public WorldTile generateTile ();

    public static WorldTile generateSample ()
    {

        AvailableResources resources = AvailableResources
                .empty()
                .addResource( SampleResources.WOOD.toResource() )
                .addResource( SampleResources.STONE.toResource() )
                .addResource( SampleResources.IRON.toResource() )
                .addResource( SampleResources.GOLD.toResource() );

        WorldTileProperties properties = WorldTileProperties
                .empty()
                .addProperty( resources );

        WorldTile tile = new WorldTile( properties );

        return tile;
    }

//    public static void main ( String [] args )
//    {
//        for ( int i = 0 ; i < 10 ; i++ )
//        {
//            System.out.println( WorldTileGenerator.generateSample() );
//            System.out.println( "--------------------------------------------------" );
//        }
//    }
}
