package com.crewgame.models.identification;

import java.util.ArrayList;
import java.util.List;

import com.crewgame.models.parsers.BuildingIdentficatorParser;

public class BuildingIdentificator {
	
	private List<String> identificators;
	
	private static BuildingIdentificator instance = null;
	
	private BuildingIdentificator()
	{
		initDependencies();
		fillIndentificators();
	}
	
	public static BuildingIdentificator getInstance()
	{
		if(instance==null)
		{
			instance = new BuildingIdentificator();
		}
		
		return instance;
	}
	
	private void initDependencies() {
		identificators = new ArrayList<String>();
		
	}

	private void fillIndentificators()
	{
		identificators = new BuildingIdentficatorParser().parseDataFromFile();
	}

	public List<String> getIdentificators() {
		return identificators;
	}
	
}
