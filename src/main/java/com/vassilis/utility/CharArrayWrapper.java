package com.vassilis.utility;

import java.util.Arrays;

public class CharArrayWrapper {
	
	private final char[] word;
	
	public CharArrayWrapper(char[] word) {
		this.word=word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(word);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharArrayWrapper other = (CharArrayWrapper) obj;
		if (!Arrays.equals(word, other.word))
			return false;
		return true;
	}
}
