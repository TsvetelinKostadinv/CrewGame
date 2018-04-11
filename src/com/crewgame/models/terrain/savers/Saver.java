package com.crewgame.models.terrain.savers;

import java.io.File;
import java.io.IOException;

import com.crewgame.fileManagement.Writer;

public interface Saver<T> 
{
	Writer writer = new Writer();
	
	public static final String separator = ",";
	
	public void save(T toSave, String path);
	
	public default void createFileIfNonExistent(String path) throws IOException 
	{
		File file = new File(path);
		if(!file.exists()) file.createNewFile();
	}
	
	public default Writer getWriter()
	{
		return writer;
	}
	
}
