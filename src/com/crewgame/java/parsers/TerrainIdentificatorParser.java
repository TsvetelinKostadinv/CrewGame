/**
 * 
 */
package com.crewgame.java.parsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.crewgame.fileManagement.Reader;
import com.crewgame.java.general.Constants;

/**
 * @author Tsvetelin
 *
 */
public class TerrainIdentificatorParser implements Parser<String> {
	
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
			File pathsFile = new File((String) Constants.PATH_TO_ABSTRACT_PATHS_FILE.getValue());
			
			Stream<String> allPaths = Files.lines(pathsFile.toPath());
			
		    String pathNeeded = allPaths.skip((int)Constants.ROW_OF_TERRAIN_PATH.getValue()-1).findFirst().get();
			
		    
		    allPaths.close();
		    
		    Reader reader = new Reader();
		    
		    String wholeFile = reader.readFile(new File(pathNeeded));
		    
		    names = Arrays.asList(wholeFile.split(","));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;
	}
}
