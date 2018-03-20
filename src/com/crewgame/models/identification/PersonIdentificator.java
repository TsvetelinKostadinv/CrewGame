/**
 * 
 */
package com.crewgame.models.identification;

/**
 * @author Tsvetelin
 *
 */
public class PersonIdentificator {
	
	private static int indentificationNumOfPerson = -1;
	
	/**
	 * @return
	 */
	public static int generateIdentificatorForPerson() {
		indentificationNumOfPerson++;
		return indentificationNumOfPerson;
	}
}
