/**
 * 
 */
package com.crewgame.models.parsers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.crewgame.fileManagement.FileReader;
import com.crewgame.models.general.Constants;

/**
 * @author Tsvetelin
 *
 */
public class PathSpeedParser implements Parser<Double> {

	@Override
	public List<Double> parseDataFromFile() {
		List<Double> coef = new ArrayList<Double>();
		try{
			File pathsFile = new File(Constants.pathToAbstactPathsFile);
			Stream<String> allPaths = Files.lines(pathsFile.toPath());
		    String pathNeeded = allPaths.skip(Constants.rowOfPathSpeedsPath-1).findFirst().get();
		    allPaths.close();
		    FileReader reader = new FileReader();
		    String wholeFile = reader.readFile(new File(pathNeeded));
		    String[] separatedValues = wholeFile.split(",");
		    for (int i = 0; i < separatedValues.length; i++)
				coef.add(Double.parseDouble(separatedValues[i]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return coef;
	}
}
