package com.crewgame.models.terrain.infrastructure.paths;

import com.crewgame.models.general.Constants;
import com.crewgame.models.parsers.PathSpeedParser;
import com.crewgame.models.parsers.PathSpeedTypeCoeficient;

public class RailRoad extends Path {
	
	private Double totalSpeed;
	
	public RailRoad() {
		super(new PathSpeedParser().parseDataFromFile().get(Constants.indexOfRailRoadSpeed));
		this.setCoefForType(new PathSpeedTypeCoeficient().parseDataFromFile().get(Constants.indexOfRailRoadSpeedCoeficient));
		this.totalSpeed = getCoefForType()*speedModifier;
	}
	
	public double getSpeed()
	{
		return totalSpeed;
	}
	
}
