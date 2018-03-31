/**
 * 
 */
package com.crewgame.models.parsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.crewgame.fileManagement.FileReader;
import com.crewgame.models.general.Constants;

/**
 * @author Tsvetelin
 *
 */
public class BuildingIdentficatorParser implements Parser<String> {
	
	/**
	 * 
	 */
	public BuildingIdentficatorParser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> parseDataFromFile() {
		List<String> names = new ArrayList<String>();
		try{
			File pathsFile = new File(Constants.pathToAbstactPathsFile);
			Stream<String> allPaths = Files.lines(pathsFile.toPath());
		    String pathNeeded = allPaths.skip(Constants.rowOfBuildingsPath-1).findFirst().get();
		    allPaths.close();
		    FileReader reader = new FileReader();
		    String wholeFile = reader.readFile(new File(pathNeeded));
		    names = Arrays.asList(wholeFile.split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;
	}
}
