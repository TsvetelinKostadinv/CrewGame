package com.crewgame.models.structures.cities.buildings;

import com.crewgame.models.exceptions.UnableToDecreaseLevelException;
import com.crewgame.models.identification.BuildingIdentificator;

public class Building {
	
	private String name;
	private int level;
	
	private int code;
	
	public Building(String name) {
		this.level = 1;
		this.name = name;
		BuildingIdentificator identif = BuildingIdentificator.getInstance();
		this.code = identif.getIdentificators().indexOf(name);
	}

	@Override
	public String toString() {
		return "Building [name=" + name + ", level=" + level + ", code=" + code + "]";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Building)
		{
			if(name.equals(((Building) obj).getName())
					&& level == ((Building) obj).getLevel()
					&& code == ((Building) obj).getCode())
			{
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}
	
	public void increaseLevel()
	{
		level+=1;
	}
	
	public void decreaseLevel() throws UnableToDecreaseLevelException
	{
		if(level>1)
		{
			level-=1;
		}else {
			throw new UnableToDecreaseLevelException();
		}
	}
	
	public int getLevel() {
		return level;
	}

	public int getCode() {
		return code;
	}
	
}
