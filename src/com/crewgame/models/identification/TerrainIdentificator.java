package com.crewgame.models.identification;

import java.util.ArrayList;
import java.util.List;

import com.crewgame.models.parsers.TerrainIdentificatorParser;

public class TerrainIdentificator {
	
	private List<String> identificators;
	
	private static TerrainIdentificator instance = null;
	
	private TerrainIdentificator()
	{
		initDependencies();
		fillIndentificators();
	}
	
	public static TerrainIdentificator getInstance()
	{
		if(instance==null)
		{
			instance = new TerrainIdentificator();
		}
		
		return instance;
	}
	
	private void initDependencies() {
		identificators = new ArrayList<String>();
		
	}

	private void fillIndentificators()
	{
		identificators = new TerrainIdentificatorParser().parseDataFromFile();
	}

	public List<String> getIdentificators() {
		return identificators;
	}
	
}
