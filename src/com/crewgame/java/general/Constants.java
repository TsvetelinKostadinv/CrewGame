package com.crewgame.java.general;

public enum Constants {
	
	MISSING_ELEMENT_PLACEHOLDER ( "#" ),
	
	/*
	 * Paths to files & row of paths
	 */
	PATH_TO_ABSTRACT_PATHS_FILE ("resources/AbstractPaths.txt"),
	ROW_OF_BUILDINGS_PATH ( 1 ),
	ROW_OF_TERRAIN_PATH ( 2 );
//	public static final int rowOfPathSpeedsPath = 3;
//	public static final int rowOfCoeficientsForTypeOfRoadPath= 4;
//	public static final int rowOfAchievementNamesPath = 5;
//	public static final int rowOfWorldSaveFile = 6;
	
	private String str = null;
	private Integer num = null;
	
	Constants(String str)
	{
		this.str = str;
	}
	
	Constants(int num)
	{
		this.num = num;
	}
	
	
	public Object getValue()
	{
		if(str == null)
		{
			return num;
		}else {
			return str; 
		}
		
	}
//	/*
//	 * Path Constants
//	 */
//	public static final int indexOfRoadSpeed = 0;
//	public static final int indexOfRailRoadSpeed = 1;
//	
	
//	/*
//	 * Path coeficients
//	 */
//	public static final int indexOfRoadSpeedCoeficient = 0;
//	public static final int indexOfRailRoadSpeedCoeficient = 1;
	
	
}
