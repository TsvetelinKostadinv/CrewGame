package com.crewgame.models.world.savers;

import java.io.File;
import java.io.IOException;

import com.crewgame.models.world.maps.WorldTile;

public class WorldTileSaver implements Saver<WorldTile> {
	
	@Override
	public void save(WorldTile toSave, String path) 
	{
		try { createFileIfNonExistent(path); }
		catch (IOException e) { e.printStackTrace(); }
		
		writer.assignFile(new File(path));
		
		writer.writeToFile(toSave.toString(), true);
		writer.writeToFile(",", true);
	}

}
