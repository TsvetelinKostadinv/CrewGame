package com.crewgame.models.terrain.infrastructure;

import com.crewgame.models.parsers.PathSpeedParser;

public class Road extends Path {
	
	
	private int level;
	
	public Road() {
		super(new PathSpeedParser().parseDataFromFile().get(0));
	}
	
	public void upgrade()
	{
		level++;
		this.speedModifier = coeficients.get(level);
	}
	
	public void downgrade()
	{
		level--;
		this.speedModifier = coeficients.get(level);
	}
}
