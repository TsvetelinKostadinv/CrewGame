package com.crewgame.models.terrain.worldGen;

import java.util.HashMap;
import com.crewgame.models.exceptions.TileOccupiedException;
import com.crewgame.models.general.Coordinate;
import com.crewgame.models.terrain.savers.LocalMapSaver;
import com.crewgame.models.terrain.savers.Saver;

public class LocalMap {
	
	HashMap<Coordinate, WorldTile> map = new HashMap<>();
	
	
	public static final int xRange = 100;
	public static final int yRange = 100;
	
	public LocalMap(){}
	
	/**
	 * 
	 * @param coord
	 * @param tile
	 * @throws TileOccupiedException
	 */
	public void insertTileOnCoordinates(Coordinate coord, WorldTile tile) throws TileOccupiedException
	{
		if(!map.containsKey(coord) 
				&& coord.getX()>=0 && coord.getX()<xRange 
				&& coord.getY()>=0 && coord.getY()<yRange) 
		{ 
			map.put(coord, tile);
		}
		else {
			throw new TileOccupiedException();
		}
	}
	
	/**
	 * 
	 * @param tile
	 */
	public void insertOnNextAvailableCoordinate(WorldTile tile)
	{
		Coordinate coord =new Coordinate(0, 0);
		for(int x=0;x<xRange;x++)
		{
			for(int y=0;y<yRange;y++)
			{
				coord.setX(x);
				coord.setY(y);
				if(!map.containsKey(coord))
				{
					map.put(coord, tile);
					return;
				}
			}
		}
	}
	/**
	 * 
	 * @return the map
	 */
	public HashMap<Coordinate, WorldTile> getMap() {
		return map;
	}
	/**
	 * 
	 * @return the xRange
	 */
	public static int getXrange() {
		return xRange;
	}
	/**
	 * 
	 * @return the yRange
	 */
	public static int getYrange() {
		return yRange;
	}
	
	public void saveMap(String toPath)
	{
		Saver<LocalMap> saver = new LocalMapSaver();
		saver.save(this, toPath);
	}
	
}
