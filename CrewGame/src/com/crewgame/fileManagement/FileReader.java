package com.crewgame.fileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader{

	public String readFile(File file) {
		
		StringBuilder text = new StringBuilder();
		
		try {
			BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
			
			String line = reader.readLine();
			
			while(line!=null){
				text.append(line);
				line = reader.readLine();
			}
			reader.close();
			reader = null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return text.toString();
	}

}
