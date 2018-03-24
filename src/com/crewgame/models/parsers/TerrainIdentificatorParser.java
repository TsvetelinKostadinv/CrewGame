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
import com.crewgame.models.Constants;

/**
 * @author Tsvetelin
 *
 */
public class TerrainIdentificatorParser implements Parser {
	
	/**
	 * 
	 */
	public TerrainIdentificatorParser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> parseDataFromFile() {
		List<String> names = new ArrayList<String>();
		try{
			File pathsFile = new File(Constants.pathToAbstactPathsFile);
			
			Stream<String> allPaths = Files.lines(pathsFile.toPath());
			
		    String pathNeeded = allPaths.skip(Constants.rowOfTerrainPath-1).findFirst().get();
			
		    System.out.println(pathNeeded);
		    
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
