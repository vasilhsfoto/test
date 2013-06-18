package com.vassilis.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.vassilis.utility.CharArrayWrapper;

public class FileCacheLoaderImpl {

	public Set<CharArrayWrapper> loadFileInCache(File file) {
		Set<CharArrayWrapper> cache = new HashSet<CharArrayWrapper>();
		BufferedReader reader=null;
		
		try {
			
			reader = new BufferedReader(new FileReader(file));
			String word;
			
			while( (word=reader.readLine()) != null) {
				cache.add(new CharArrayWrapper(word.toCharArray()));
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
