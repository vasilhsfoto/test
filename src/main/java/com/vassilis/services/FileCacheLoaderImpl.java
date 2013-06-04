package com.vassilis.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileCacheLoaderImpl implements FileCacheLoader {

	public Set<String> loadFileInCache(File file) {
		Set<String> cache = new HashSet<String>();
		BufferedReader reader=null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String word;
			
			while( (word=reader.readLine()) != null) {
				cache.add(word);
			}
			
			return cache;
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("error creating the cach holded the content of the small file" + e);
		} catch (IOException e) {
			throw new RuntimeException("error creating the cach holded the content of the small file" + e);		} finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new RuntimeException("error creating the cach holded the content of the small file" + e);
				}
			}
		}
	}
}
