/**
 * 
 */
package com.crewgame.models.CrewMembers;

import com.crewgame.models.identification.PersonIdentificator;

/**
 * @author Tsvetelin
 *
 */
public class Person {
	
	private String name;
	private String secondName;
	private String thirdName;
	
	private Race race;
	private Job job;
	
	
	private int age;
	private int identificationNumber;
	private int happiness;
	
	private double battleSwordCoeficent;
	private double battleAxeCoeficient;
	private double battlePikeCoeficient;
	private double battleBowCoeficient;
	
	private double battleShieldCoeficient;
	
	private double stoneGatherCoeficient;
	private double stoneProcessCoeficient;
	
	private double woodGatherCoeficient;
	private double woodProcessCoeficient;
	
	private boolean mortal = false;
	
	public Person(String name, String secondName, String thirdName, Race race, int age, int happiness)
	{
		this.name = name;
		this.secondName = secondName;
		this.thirdName = thirdName;
		
		this.race = race;
		
		this.identificationNumber = PersonIdentificator.generateIdentificatorForPerson();
		
		this.age = age;
		this.happiness = happiness;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}


	/**
	 * @return the thirdName
	 */
	public String getThirdName() {
		return thirdName;
	}

	/**
	 * @return the race
	 */
	public Race getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the identificationNumber
	 */
	public int getIdentificationNumber() {
		return identificationNumber;
	}

	/**
	 * @param identificationNumber the identificationNumber to set
	 */
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	/**
	 * @return the happiness
	 */
	public int getHappiness() {
		return happiness;
	}

	/**
	 * @param happiness the happiness to set
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	/**
	 * @return the mortal
	 */
	public boolean isMortal() {
		return mortal;
	}

	/**
	 * @param mortal the mortal to set
	 */
	public void setMortal(boolean mortal) {
		this.mortal = mortal;
	}
	
}
