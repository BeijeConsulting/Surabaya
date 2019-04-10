package it.beije.surabaya.esempi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CSVutils {
	
	public static List<String> getFileAsStrings(String pathFile) throws Exception {
		List<String> content = new ArrayList<String>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(pathFile));
			
			while(reader.ready()) {
				content.add(reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				reader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		
		return content;
	}
	
	public static void main (String[] args) throws Exception {
		File file = new File("C:\\temp\\pippo.txt");
		//System.out.println(file.exists());		
		//FileWriter fw = new FileWriter(file);
		
		FileReader fileReader = null;
		BufferedReader reader = null;
		try {
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
			
			while(reader.ready()) {
				System.out.println(reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				reader.close();
				fileReader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

}