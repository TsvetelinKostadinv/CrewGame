package com.crewgame.models.structures.cities;

import java.util.ArrayList;
import java.util.List;

import com.crewgame.models.player.Player;
import com.crewgame.models.structures.Structure;
import com.crewgame.models.structures.cities.buildings.Building;

public class City extends Structure{
	
	private List<Building> buildings;
	
	
	public City(Player owner) {
		initDependencies();
		this.owner = owner;
	}
	

	private void initDependencies() {
		buildings = new ArrayList<Building>();
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


	@Override
	public String toString() {
		return name + "," + level + "," + owner.toString();
	}

}
