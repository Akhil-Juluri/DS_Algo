/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static String smallestSubstringContainingAllCharsOfPattern(String source, String pattern) {
        int n = source.length(), k = pattern.length();
        String res = "";
        if (n < k) {
            return res;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < k; i++) {
            char ch = pattern.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch)+1);
            } else {
                hm.put(ch, 1);
            }
        }
        //System.out.println(hm);
        int start = 0, startIndex = -1, endIndex = -1, count = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            char ch = source.charAt(end);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch)-1);
                if (hm.get(ch) == 0) { // here we can also use "if (hm.get(ch) >= 0) {" i.e for every character of pattern we are incrementing count
                    count++;
                }
            }
	    /* if we use if (hm.get(ch) == 0) means we are incrementing count only when all distinct chars in freqeuncy map becomes 0
	    if we use if (hm.get(ch) >= 0) means we are incrementing count for every character of pattern in the string */
	    	
	    
	    /* here if once all the chars of pattern are found in string then we will try to shrink the string from start
	    if a character frequency is 0 i.e it has been included in the current substring and we are now not considering it 
	    so count will be decremented by 1, since we ignored that character we have place it back for next consideration so we increment
	    it's frequency by 1, at that time condition fails and we will search if there is any other string minimal than current result*/
            while (count == hm.size()) { // "if (hm.get(ch) >= 0) {" is used above then this should be while (count == pattern.length()) {
                if (min > end - start + 1) {
                    res = source.substring(start, end + 1);
                    min = end - start + 1;
                }
                char c = source.charAt(start);
                if (hm.containsKey(c)) {
                    if (hm.get(c) == 0) {
                        count--;
                    }
                    hm.put(c,hm.get(c)+1);
                }
                start++;
                //System.out.println(res);
            }
        }
        return res;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String source = sc.next();
		String pattern = sc.next();
		System.out.println(smallestSubstringContainingAllCharsOfPattern(source, pattern));
	}
}
/*
Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
*/
