package com.crewgame.fileManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

    File targetFile;

    public FileWriter() {}

    public void assignFile(File file) {
        targetFile = file;
    }

    public void writeToFile(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new PrintWriter(targetFile));
            writer.write(str);
            writer.close();
            writer = null;
        }catch (FileNotFoundException e )
        {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
