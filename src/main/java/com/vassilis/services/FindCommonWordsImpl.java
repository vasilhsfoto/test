package com.vassilis.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import com.vassilis.utility.CharArrayWrapper;

/**
 * This class finds the common words and at the same time emits the results
 * into a 3rd file which will eventually contain the common words.
 * From engineering point of view, we could decouple the second functionality 
 * creating a separate layer (DAO) responsible for storing the common words to a storage
 * device regardless of what it is.
 * 
 * @author Vassilis Fotopoulos
 *
 */
public class FindCommonWordsImpl {
	
	public void findCommonWords(Set<CharArrayWrapper> smallFileCache, File file, File destinationFile) {
		BufferedReader reader=null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			writer = new BufferedWriter(new FileWriter(destinationFile));
			String word;
			
			while( (word=reader.readLine()) != null) {
				if(smallFileCache.contains(new CharArrayWrapper(word.toCharArray()))) {
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
