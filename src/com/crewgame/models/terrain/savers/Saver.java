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
		String[] dirs = path.split("/");
		StringBuilder pathBeforeFile = new StringBuilder();
		for(int i=0;i<dirs.length;i++) 
		{
			if(i!=dirs.length-1)
			{
				pathBeforeFile.append(dirs[i]);
				pathBeforeFile.append(File.separator);
			}
			
		}
		File dir = new File(pathBeforeFile.toString());
		File file = new File(path);
		
		dir.mkdirs();
		file.createNewFile();
	}
	
	public default Writer getWriter()
	{
		return writer;
	}
	
}
