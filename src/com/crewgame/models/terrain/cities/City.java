package com.crewgame.models.terrain.cities;

import java.util.ArrayList;
import java.util.List;

import com.crewgame.models.exceptions.UnableToDecreaseLevelException;
import com.crewgame.models.player.Player;
import com.crewgame.models.terrain.cities.buildings.Building;

public class City {
	
	private String name;
	private int level;
	
	private Player owner;
	
	private List<Building> buildings;
	
	public City(Player owner) {
		initDependencies();
		this.owner = owner;
	}

	private void initDependencies() {
		buildings = new ArrayList<Building>();
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @author Tsvetelin
	 */
	public void increaseLevel() {
		this.level +=1;
	}
	
	public void decreaseLevel() throws UnableToDecreaseLevelException {
		if(level>1)
		{
			level-=1;
		}else {
			throw new UnableToDecreaseLevelException();
		}
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public List<Building> getBuildings()
	{
		return buildings;
	}
	
	public void addBuilding(Building building)
	{
		
		if(!buildings.contains(building))
		{
			buildings.add(building);
		}else {
			int index = buildings.indexOf(building);
			buildings.get(index).increaseLevel();
		}
	}
	
	public void removeBuilding(Building building)
	{
		if(!buildings.contains(building))
		{
			buildings.add(building);
		}else {
			int index = buildings.indexOf(building);
			buildings.get(index).increaseLevel();
		}
	}

}
