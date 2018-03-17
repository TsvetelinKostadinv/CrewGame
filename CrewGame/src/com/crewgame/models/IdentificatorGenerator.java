/**
 * 
 */
package com.crewgame.models;

/**
 * @author Tsvetelin
 *
 */
public class IdentificatorGenerator {
	
	private static int indentificationNumOfPerson = -1;
	
	/**
	 * @return
	 */
	public static int generateIdentificatorForPerson() {
		indentificationNumOfPerson++;
		return indentificationNumOfPerson;
	}
}
