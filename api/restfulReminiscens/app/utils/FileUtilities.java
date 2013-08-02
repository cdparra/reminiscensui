package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtilities {


	/**
	 * This corresponds to the delimiter of the file path for the current
	 * operating system.
	 */
	public static String slash = (System.getProperty("os.name")
		.indexOf("Windows") != -1) ? "\\" : "/";
    
    public static File readFile(String fullPath) {
    	return new File(fullPath);
    }
    
    public static String generateHashCode(String fullPath, Long userId, String contentType) {
    	// TODO implement hash code for files generation
    	return ""; 
    }
    
    // TODO implement file supporting utilities
}
