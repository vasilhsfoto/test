package com.vassilis.services;

import java.io.File;
import java.util.Set;

public interface FindCommonWords {
	void findCommonWords(Set<String> smallFileCache, File file, File destinationFile);
}
