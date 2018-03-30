package com.crewgame.models.structures;

import com.crewgame.models.exceptions.UnableToDecreaseLevelException;
import com.crewgame.models.player.Player;

public abstract class Structure {
	
	protected String name;
	protected int level;
	
	protected Player owner;
	
	public Structure() {
		
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
}
