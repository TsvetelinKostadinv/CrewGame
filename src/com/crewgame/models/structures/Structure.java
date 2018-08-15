package com.crewgame.models.structures;

import com.crewgame.models.exceptions.UnableToDecreaseLevelException;
import com.crewgame.models.general.Constants;
import com.crewgame.models.world.savers.Saver;

public abstract class Structure {
	
	protected String name;
	protected int level;
	
	public int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append(name);
		info.append(Saver.separator);
		//if(owner != null) info.append(owner.getId()); else info.append(Constants.missingElementPlaceHolder);
		info.append(Saver.separator);
		info.append(level);
		return info.toString();
		
	}
}
