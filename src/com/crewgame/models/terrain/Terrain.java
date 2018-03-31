/**
 * 
 */
package com.crewgame.models.terrain;

/**
 * @author Tsvetelin
 *
 */
public class Terrain {
	private String type;
	
	private double goldMultiplier;
	private double metalMultiplier;
	private double farmMultiplier;
	private double woodMultiplier;
	
	
	public String getType() {
		return type;
	}
	public double getGoldMultiplier() {
		return goldMultiplier;
	}
	public void increaseGoldMultiplier() {
		this.goldMultiplier+=Math.random();
	}
	public void decraseGoldMultiplier() {
		this.goldMultiplier-=Math.random();
	}
	
	public double getMetalMultiplier() {
		return metalMultiplier;
	}
	public void increaseMetalMultiplier() {
		this.metalMultiplier+=Math.random();
	}
	public void decraseMetalMultiplier() {
		this.metalMultiplier-=Math.random();
	}
	
	public double getFarmMultiplier() {
		return farmMultiplier;
	}
	public void increaseFarmMultiplier() {
		this.farmMultiplier+=Math.random();
	}
	public void decraseFarmMultiplier() {
		this.farmMultiplier-=Math.random();
	}
	
	public double getWoodMultiplier() {
		return woodMultiplier;
	}
	public void increaseWoodMultiplier() {
		this.woodMultiplier+=Math.random();
	}
	public void decraseWoodMultiplier() {
		this.woodMultiplier-=Math.random();
	}
	
	@Override
	public String toString() {
		return type 
				+ "," + goldMultiplier 
				+ "," + metalMultiplier 
				+ "," + farmMultiplier 
				+ "," + woodMultiplier;
	}
	
}
