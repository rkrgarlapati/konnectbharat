package com.kb.utility;

import java.util.Random;

public enum GenerateUniqueID {
	
	INSTANCE; 
	
	public String generateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : new Random()
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }
}
