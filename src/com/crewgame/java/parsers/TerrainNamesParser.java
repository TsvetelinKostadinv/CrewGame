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

import com.crewgame.fileManagement.reading.Reader;
import com.crewgame.java.general.Constants;

/**
 * @author Tsvetelin
 *
 */
public class TerrainNamesParser implements Parser<String> {
	
	private List<String> names;
	
	/**
	 * 
	 */
	public TerrainNamesParser() 
	{
		initDependencies();
	}

	private void initDependencies() 
	{
		names = new ArrayList<String>();
		
	}

	@Override
	public List<String> parseDataFromFile() 
	{
		if(names == null || names.size()==0) 
		{
			names = new ArrayList<String>();
			try{
				File pathsFile = new File((String) Constants.Paths.PATH_TO_ABSTRACT_PATHS_FILE.getValue());
				
				Stream<String> allPaths = Files.lines(pathsFile.toPath());
				
			    String pathNeeded = allPaths.skip((int)Constants.RowsOfPaths.ROW_OF_TERRAIN_PATH.getValue()-1).findFirst().get();
				
			    allPaths.close();
			    
			    Reader reader = new Reader();
			    
			    String wholeFile = reader.readFile(new File(pathNeeded));
			    
			    names = Arrays.asList(wholeFile.split(","));
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return names;
	}
}
