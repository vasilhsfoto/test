package com.vassilis.services;

import java.io.File;
import java.util.Set;

public interface FileCacheLoader {
	Set<String> loadFileInCache(File file);
}
