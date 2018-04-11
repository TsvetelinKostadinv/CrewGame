package com.crewgame.models.terrain.tests;

import com.crewgame.models.terrain.Terrain;
import com.crewgame.models.terrain.worldGen.LocalMap;
import com.crewgame.models.terrain.worldGen.WorldTile;

public class WorldGenTest {

	public static void main(String[] args) {
		LocalMap localMap = new LocalMap();
		WorldTile tile = new WorldTile(3000, 1500, 2000, 1500, new Terrain("Rocky", 1.5, 2, 1, 0.4));
		localMap.insertOnNextAvailableCoordinate(tile);
		localMap.saveMap("resources/saves/map.txt");

	}

}
