package com.santhosh.filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileReader {


	public static void main (String args[]){
		FileInputStream fis = null;
		BufferedReader br = null;
				
		try {
			fis = new FileInputStream("/Users/santhoshanandramia/java/test.txt");
			br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			
			String currentLine = br.readLine();
			while(currentLine != null){
				System.out.println("Currnet Line "+currentLine);
				
				currentLine = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}


