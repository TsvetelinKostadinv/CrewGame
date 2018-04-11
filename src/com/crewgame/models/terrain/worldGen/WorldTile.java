/**
 * 
 */
package com.crewgame.models.terrain.worldGen;

import com.crewgame.models.general.Constants;
import com.crewgame.models.player.Player;
import com.crewgame.models.structures.cities.City;
import com.crewgame.models.terrain.Terrain;
import com.crewgame.models.terrain.savers.Saver;

/**
 * @author Tsvetelin
 *
 */
public class WorldTile {
	private Player owner;
	private City city;
	private Terrain terrain;
	
	private int minableGold;
	private int mineableMetal;
	private int farmableLand;
	private int availableWood;
	
	/**
	 * @param minableGold
	 * @param mineableMetal
	 * @param farmableLand
	 * @param terrain
	 */
	public WorldTile(int minableGold, int mineableMetal, int farmableLand,int availableWood, Terrain terrain) {
		super();
		this.minableGold = minableGold;
		this.mineableMetal = mineableMetal;
		this.farmableLand = farmableLand;
		this.terrain = terrain;
		this.setAvailableWood(availableWood);
	}

	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		if(owner!=null) sb.append(owner.toString()); else sb.append(Constants.missingElementPlaceHolder);
		sb.append(Saver.separator);
		sb.append(minableGold );
		sb.append(Saver.separator);
		sb.append(mineableMetal );
		sb.append(Saver.separator);
		sb.append(farmableLand );
		sb.append(Saver.separator);
		sb.append(availableWood );
		sb.append(Saver.separator);
		if (city != null) sb.append(city.toString()); else sb.append(Constants.missingElementPlaceHolder);
		sb.append(Saver.separator);
		sb.append(terrain.toString());

		
		return sb.toString();
		
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


	/**
	 * @return the availableWood
	 */
	public int getAvailableWood() {
		return availableWood;
	}


	/**
	 * @param availableWood the availableWood to set
	 */
	public void setAvailableWood(int availableWood) {
		this.availableWood = availableWood;
	}
	
	
	
}
