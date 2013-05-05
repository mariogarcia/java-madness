package jdkseven.trycatch;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * This class has some examples about the new syntax of try-catch blocks from
 * JDK7
 *
 * @author @marioggar 
 *
 **/
public class ReadingAndClosingAFileStream{

	private static final String BLANK = "";

	@SuppressWarnings("serial")
	private class CustomException extends Exception{
		public CustomException(String message){
			super(message);
		}
	}

	/**
	 * This method returns a list of country names from the file passed
	 * as parameter
	 *
	 * @param file The file we're going to read
	 * @return a list of country names
	 * @throws CustomException 
	 **/
	public List<String> getCountriesFromFile(File file) throws CustomException{
		List<String> countries = new ArrayList<String>(); 
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){ 
			String line = BLANK; 
			while((line = reader.readLine()) != null){
				countries.add(line.trim());
			}
		} catch (IOException exception){
			throw new CustomException(exception.getMessage());		
		}
		return countries;
	}

}
