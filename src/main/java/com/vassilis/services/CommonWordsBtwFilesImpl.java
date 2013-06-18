package com.vassilis.services;

import java.io.File;
import java.util.Set;

import com.vassilis.utility.CharArrayWrapper;

public class CommonWordsBtwFilesImpl implements CommonWordsBtwFiles {
	private final File fileA;
	private final File fileB;
	private final File fileC;
	
	private FileCacheLoaderImpl fileCacheLoader;
	private FindCommonWordsImpl findCommonWords;
	
	public CommonWordsBtwFilesImpl(File fileA, File fileB, File fileC,
								   FileCacheLoaderImpl fileCacheLoader,	
								   FindCommonWordsImpl findCommonWords) {
		this.fileA=fileA;
		this.fileB=fileB;
		this.fileC=fileC;
		this.fileCacheLoader=fileCacheLoader;
		this.findCommonWords=findCommonWords;
	}

	public void process() {
		File smallFile, largeFile;
		
		if(fileA.length()<=fileB.length()) {
			smallFile = fileA;
			largeFile = fileB;
		} else {
			smallFile = fileB;
			largeFile = fileA;
		}
		
		Set<CharArrayWrapper> smallFileCache = fileCacheLoader.loadFileInCache(smallFile);
		
		findCommonWords.findCommonWords(smallFileCache, largeFile, fileC);
	}
}
