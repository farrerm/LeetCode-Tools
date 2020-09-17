package leetCode;
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LCode {
	
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
	
	
	public static int maxSubsetSum(int[] arr) {
			return maxSubsetRecursive(arr, 0, 0);
	}
		
	
    public static int maxSubsetRecursive(int[] arr, int sumSoFar, int leftIndex){
    	if(leftIndex < arr.length-2){
    		int max = Math.max(sumSoFar + arr[leftIndex] + maxSubsetRecursive(arr, sumSoFar, leftIndex + 2), sumSoFar + maxSubsetRecursive(arr, sumSoFar, leftIndex + 1));
    		return max;
      
    	}
    	else if (leftIndex < arr.length-1){
    		int max = Math.max(sumSoFar + arr[leftIndex], sumSoFar + maxSubsetRecursive(arr, sumSoFar, leftIndex + 1));
    		return max;
    	}
    	else if (leftIndex < arr.length){
    		int max = Math.max(sumSoFar, sumSoFar + arr[leftIndex]);
    		return max;
    	}
    	else{
    		return sumSoFar;
    	}
    }
  
private static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	
	private static int choose(int total, int choose){
	    if(total < choose)
	        return 0;
	    if(choose == 0 || choose == total)
	        return 1;

	    if (! (map.containsKey(total) && map.get(total).containsKey(choose))){
	        map.put(total, new HashMap<>());
	        map.get(total).put(choose, choose(total-1,choose-1)+choose(total-1,choose));
	    }
	    return map.get(total).get(choose);
	}
}
