package com.crewgame.models.terrain.infrastructure.paths;

import com.crewgame.models.general.Constants;
import com.crewgame.models.parsers.PathSpeedParser;
import com.crewgame.models.parsers.PathSpeedTypeCoeficient;

public class Road extends Path {
	
	private Double totalSpeed;
	
	public Road() {
		super(new PathSpeedParser().parseDataFromFile().get(Constants.indexOfRoadSpeed));
		this.setCoefForType(new PathSpeedTypeCoeficient().parseDataFromFile().get(Constants.indexOfRoadSpeedCoeficient));
		this.totalSpeed = getCoefForType()*speedModifier;
	}
	
	public double getSpeed()
	{
		return totalSpeed;
	}
	
}
