package com.vassilis.testdrive;

import java.io.File;

import com.vassilis.services.CommonWordsBtwFiles;
import com.vassilis.services.CommonWordsBtwFilesImpl;
import com.vassilis.services.FileCacheLoaderImpl;
import com.vassilis.services.FindCommonWordsImpl;

public class TestDriver {

	public static void main(String[] args) {
		sanityCheck(args);
		
		CommonWordsBtwFiles orchestrator = new CommonWordsBtwFilesImpl(new File(args[0]), new File(args[1]), new File(args[2]), 
																	   new FileCacheLoaderImpl(), new FindCommonWordsImpl());
		
		orchestrator.process();
	}
	
	private static void sanityCheck(String[] args) {
		if(args.length!=3) {
			System.out.println("find common words between files requires 3 arguments...");
			System.exit(-1);
		}
		/* more detail sanity check goes here*/
	}
}
