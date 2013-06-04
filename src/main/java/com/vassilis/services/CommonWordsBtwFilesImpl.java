package com.vassilis.services;

import java.io.File;
import java.util.Set;

public class CommonWordsBtwFilesImpl implements CommonWordsBtwFiles {
	private final File fileA;
	private final File fileB;
	private final File fileC;
	
	private FileCacheLoader fileCacheLoader;
	private FindCommonWords findCommonWords;
	
	public CommonWordsBtwFilesImpl(File fileA, File fileB, File fileC,
								   FileCacheLoader fileCacheLoader,	
								   FindCommonWords findCommonWords) {
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
		
		Set<String> smallFileCache = fileCacheLoader.loadFileInCache(smallFile);
		
		findCommonWords.findCommonWords(smallFileCache, largeFile, fileC);
	}
}
