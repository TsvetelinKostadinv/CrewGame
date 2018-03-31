/**
 * 
 */
package com.crewgame.models.terrain.worldGen;

import com.crewgame.models.player.Player;
import com.crewgame.models.structures.cities.City;
import com.crewgame.models.terrain.Terrain;

/**
 * @author Tsvetelin
 *
 */
public class WorldTile {
	
	private Player owner;
	
	private int minableGold;
	private int mineableMetal;
	private int farmableLand;
	
	private City city;
	private Terrain terrain;
	
	@Override
	public String toString() {
		return owner.toString() 
				+ "," + minableGold 
				+ "," + mineableMetal  
				+ "," + farmableLand  
				+ "," + city.toString() 
				+ "," + terrain.toString();
	}
	
	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	/**
	 * @return the minableGold
	 */
	public int getMinableGold() {
		return minableGold;
	}
	/**
	 * @param minableGold the minableGold to set
	 */
	public void setMinableGold(int minableGold) {
		this.minableGold = minableGold;
	}
	/**
	 * @return the mineableMetal
	 */
	public int getMineableMetal() {
		return mineableMetal;
	}
	/**
	 * @param mineableMetal the mineableMetal to set
	 */
	public void setMineableMetal(int mineableMetal) {
		this.mineableMetal = mineableMetal;
	}
	/**
	 * @return the farmableLand
	 */
	public int getFarmableLand() {
		return farmableLand;
	}
	/**
	 * @param farmableLand the farmableLand to set
	 */
	public void setFarmableLand(int farmableLand) {
		this.farmableLand = farmableLand;
	}
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * @return the terrain
	 */
	public Terrain getTerrain() {
		return terrain;
	}
	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	
	
}
