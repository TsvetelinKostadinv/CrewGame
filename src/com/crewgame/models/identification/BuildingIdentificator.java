package com.crewgame.models.identification;

import java.io.File;
import java.util.HashMap;

import com.crewgame.fileManagement.FileReader;

public class BuildingIdentificator {
	
	private HashMap<String, Integer> indentificators;
	
	private static BuildingIdentificator instance = null;
	
	private BuildingIdentificator()
	{
		initDependencies();
		fillIndentificators();
	}
	
	public BuildingIdentificator getInstance()
	{
		if(instance==null)
		{
			instance = new BuildingIdentificator();
		}
		
		return instance;
	}
	
	private void initDependencies() {
		indentificators = new HashMap<>();
		
	}

	private void fillIndentificators()
	{
		
	}
	
}
