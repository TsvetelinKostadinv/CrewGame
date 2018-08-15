package com.crewgame.fileManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Reader{

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
	
	public String readRowOfFile(File file, int row)
	{
		try {
			Stream<String> allLines = Files.lines(file.toPath());
			String rowNeeded = allLines.skip(row-1).findFirst().get();
			allLines.close();
			return rowNeeded;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
