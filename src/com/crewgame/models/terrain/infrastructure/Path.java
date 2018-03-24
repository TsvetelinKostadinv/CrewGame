package com.crewgame.models.terrain.infrastructure;

import java.util.List;

import com.crewgame.models.parsers.PathSpeedParser;

public abstract class Path {
	
	double speedModifier;
	List<Double> coeficients = new PathSpeedParser().parseDataFromFile();
	
	public Path(double speedModifier) {
		this.speedModifier = speedModifier;
	}

	public double getSpeedModifier()
	{
		return speedModifier;
	}
	
}
