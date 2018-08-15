package com.crewgame.models.world.savers;

import java.io.File;
import java.io.IOException;

import com.crewgame.models.structures.Structure;

public class StructureReferenceSaver implements Saver<Structure> {

	@Override
	public void save(Structure toSave, String path) {
		
		try { createFileIfNonExistent(path);
		} catch (IOException e) { e.printStackTrace(); }
		
		writer.assignFile(new File(path));
		writer.writeToFile(toSave.toString(), true);
		writer.writeToFile(separator, true);
		writer.writeToFile(System.lineSeparator(), true);
	}

}
