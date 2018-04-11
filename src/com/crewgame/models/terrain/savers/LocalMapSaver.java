package com.crewgame.models.terrain.savers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.crewgame.models.general.Coordinate;
import com.crewgame.models.terrain.worldGen.LocalMap;
import com.crewgame.models.terrain.worldGen.WorldTile;

public class LocalMapSaver implements Saver<LocalMap> {
	
	
	@Override
	public void save(LocalMap toSave, String path) 
	{
		try {
			createFileIfNonExistent(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashMap<Coordinate, WorldTile> map = toSave.getMap();
		
		Saver<Coordinate> coordSaver = new CoordinateSaver();
		Saver<WorldTile> tileSaver = new WorldTileSaver();
		
		for(Entry<Coordinate, WorldTile> entry : map.entrySet())
		{
			Coordinate coord = entry.getKey();
			WorldTile tile = entry.getValue();
			
			coordSaver.save(coord, path);
			tileSaver.save(tile, path);
		}
		
	}
}
