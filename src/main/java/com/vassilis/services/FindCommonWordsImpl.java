package com.vassilis.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class FindCommonWordsImpl implements FindCommonWords {
	
	public void findCommonWords(Set<String> smallFileCache, File file, File destinationFile) {
		BufferedReader reader=null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(destinationFile));
			String word;
			
			while( (word=reader.readLine()) != null) {
				if(smallFileCache.contains(word)) {
					writer.write(word);
				}
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("error on finding the common words" + e);
		} catch (IOException e) {
			throw new RuntimeException("error on finding the common words" + e);		
		} finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("error on finding the common words" + e);
				}
			}
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					throw new RuntimeException("error on finding the common words" + e);
				}
			}
		}
	}
}
