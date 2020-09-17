package leetCode;
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IncrementBinaryString {
	
	public static void main(String[] args) {
		
		boolean answer = containsNotContiguous("Salamia", "ala");
		if (answer) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
	public static boolean containsNotContiguous(String big, String small) {
		int startIndex = -1;
		for(int i = 0; i < big.length(); i++) {
			if (big.charAt(i) == small.charAt(0)) {
				System.out.println("found start at " + i);
				startIndex = i;
				int StringRange = big.length() - i;
				System.out.println("StringRange = " + StringRange);
				if (StringRange <= small.length()) {
					return false;
				}
				
				for (int j = 0; j < Math.pow(2, StringRange); j++ ) {
					String binaryString = Integer.toBinaryString(j);
					StringBuilder binRange = new StringBuilder();
					binRange.append('%');
					binRange.append(Integer.toString(StringRange));
					binRange.append('s');
					String binaryRange = binRange.toString();
					//System.out.println(bitSet);
					String binZeros = String.format(binaryRange, binaryString).replace(' ', '0');
					System.out.println(binZeros);
					StringBuilder myBuilder = new StringBuilder();
					int lastChar = -1;
					for (int k = 0; k < StringRange; k++) {
						System.out.println("k = " + k);
						if (binZeros.charAt(k) == '1') {
							lastChar = k;
							System.out.println("lastChar = " + lastChar);
							myBuilder.append(big.charAt(i + k));
							System.out.println(myBuilder.toString());
							if (myBuilder.toString().equals(small)) {
								
								if (lastChar == small.length()-1) {
									continue;
								}
								else {
									return true;
								}
							}
						}
					}
					
				}
				
				
			}
		}
		
		
		return false;
	}
}
	
	