/**
 * 
 */
package com.crewgame.models.player;

/**
 * @author Tsvetelin
 *
 */
public class Player {
	
	private String username;
	private String password;
	
	private int gold;
	
	private Achievement[] achevements;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return username + "," + password +","+ gold ;
	}
	
}
