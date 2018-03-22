package com.crewgame.models.parsers;

import java.util.List;

@FunctionalInterface
public interface Parser {
	/**
	 * @author Tsvetelin
	 * @param file
	 * @return the map of Values(type HashMap<String, Integer>)
	 */
	public List<String> parseDataFromFile();

}
