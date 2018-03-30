package com.crewgame.models.terrain.infrastructure.paths;

import java.util.List;

import com.crewgame.models.exceptions.UnableToDecreaseLevelException;
import com.crewgame.models.parsers.PathSpeedParser;

public abstract class Path {
	
	double speedModifier;
	private int level;
	private double coefForType = 0;


	List<Double> coeficientsForLevels = new PathSpeedParser().parseDataFromFile();
	
	public Path(double speedModifier) {
		this.speedModifier = speedModifier;
	}

	public double getSpeedModifier()
	{
		return speedModifier;
	}

	public void upgrade()
	{
		level++;
		this.speedModifier = coeficientsForLevels.get(level);
	}
	
	public void downgrade() throws UnableToDecreaseLevelException
	{
		if(level>1)
		{
			level--;
			this.speedModifier = coeficientsForLevels.get(level);
		}else throw new UnableToDecreaseLevelException();
	}
	
	public double getCoefForType() {
		return coefForType;
	}

	public void setCoefForType(double coefForType) {
		this.coefForType = coefForType;
	}
	
	
}
