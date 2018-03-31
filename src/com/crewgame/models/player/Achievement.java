/**
 * 
 */
package com.crewgame.models.player;

/**
 * @author Tsvetelin
 *
 */
public class Achievement {
	
	private String name;
	private int id;
	private String tooltip;
	
	public Achievement(String name, String tooltip)
	{
		this.name = name;
		this.tooltip = tooltip;
	}

	/**
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * @param tooltip the tooltip to set
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}
