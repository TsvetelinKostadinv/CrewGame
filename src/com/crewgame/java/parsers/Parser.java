package com.crewgame.java.parsers;

import java.util.List;

@FunctionalInterface
public interface Parser<T> {
	/**
	 * @author Tsvetelin
	 * @param <T>
	 * @param file
	 * @return the map of Values(type HashMap<String, Integer>)
	 */
	public List<T> parseDataFromFile();

}
