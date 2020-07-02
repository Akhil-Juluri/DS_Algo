/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int longestSubStringWithNoRepeatingChars(String str) {
        int start = 0, maxLen = 0, startIndex = -1, endIndex = -1;
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int end = 0; end < str.length(); end++) {
            if (hs.containsKey(str.charAt(end))) {
                hs.put(str.charAt(end), hs.get(str.charAt(end)) + 1);
            } else {
                hs.put(str.charAt(end), 1);
            }
            while(hs.get(str.charAt(end)) > 1) {
                hs.put(str.charAt(start), hs.get(str.charAt(start)) - 1);
                start++;
            }
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                startIndex = start;
                endIndex = end;
                // stores indices of first longest SubString With No Repeating Chars
                // to have last longest SubString With No Repeating Chars use end - start + 1 >= maxLen
            }
        }
        //System.out.println(startIndex+" "+endIndex);
        return maxLen;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(longestSubStringWithNoRepeatingChars(str));
	}
}
/*
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
*/
