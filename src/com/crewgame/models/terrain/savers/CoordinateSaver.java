package com.crewgame.models.terrain.savers;

import java.io.File;
import java.io.IOException;

import com.crewgame.models.general.Coordinate;

public class CoordinateSaver implements Saver<Coordinate> {
	
	@Override
	public void save(Coordinate toSave, String path) 
	{
		try { createFileIfNonExistent(path); }
		catch (IOException e) { e.printStackTrace(); }
		
		writer.assignFile(new File(path));
		
		writer.writeToFile(toSave.toSimpleString(), true);
		writer.writeToFile(separator, true);
		
	}

}
