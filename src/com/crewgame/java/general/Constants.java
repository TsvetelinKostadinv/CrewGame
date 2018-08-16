package com.crewgame.java.general;

public enum Constants 
{
	; // this is here because Java requires the values in the enum to be the very first thing you define
	public static enum Paths
	{
		PATH_TO_ABSTRACT_PATHS_FILE ("resources/AbstractPaths.txt");
		
		private String value = null;
		
		private Paths(String value) { this.value = value; }
		
		public String getValue() { return value; }
	}
	
	public static enum RowsOfPaths
	{
		ROW_OF_BUILDINGS_PATH ( 1 );
		
		private Integer value = null;
		
		private RowsOfPaths(Integer value) { this.value = value; }
		
		public Integer getValue() { return value; }
	}
	
	public static enum CrewGameSpecialSymbols
	{
		MISSING_ELEMENT_PLACEHOLDER ( "#" ),
		SAVES_DATA_SEPARATOR_SYMBOL (",");
		
		private String value = null;
		
		private CrewGameSpecialSymbols(String value) { this.value = value; }
		
		public String getValue() { return value; }
	}
//	MISSING_ELEMENT_PLACEHOLDER ( "#" ),
//	
//	/*
//	 * Paths to files & row of paths
//	 */
//	PATH_TO_ABSTRACT_PATHS_FILE ("resources/AbstractPaths.txt"),
//	ROW_OF_BUILDINGS_PATH ( 1 ),
//	ROW_OF_TERRAIN_PATH ( 2 );
////	public static final int rowOfPathSpeedsPath = 3;
////	public static final int rowOfCoeficientsForTypeOfRoadPath= 4;
////	public static final int rowOfAchievementNamesPath = 5;
////	public static final int rowOfWorldSaveFile = 6;

}
