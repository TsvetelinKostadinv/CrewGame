package com.crewgame.fileManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {

    File targetFile;

    public Writer() {}

    public void assignFile(File file) {
        targetFile = file;
    }

    public void writeToFile(String str, boolean append) {
        try {
        	PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(targetFile, append)));
            writer.write(str);
            writer.close();
            writer = null;
        }catch (FileNotFoundException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
}
