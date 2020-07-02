/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int longestSubStringWithAtmostKDistinctChars(String str, int k) {
        if (k == 0) {
            return k;
        }
        int start = 0, maxLen = 0, startIndex = -1, endIndex = -1;
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int end = 0; end < str.length(); end++) {
            if (hs.containsKey(str.charAt(end))) {
                hs.put(str.charAt(end), hs.get(str.charAt(end)) + 1);
            } else {
                hs.put(str.charAt(end), 1);
            }
            while(hs.size() > k) {
                hs.put(str.charAt(start), hs.get(str.charAt(start)) - 1);
                if (hs.get(str.charAt(start)) == 0) {
                    hs.remove(str.charAt(start));
                }
                start++;
            }
            //if (hs.size() == k) { // for longest SubString With exactly K Distinct Chars
		    if (end - start + 1 > maxLen) {
			maxLen = end - start + 1;
			startIndex = start;
			endIndex = end;
			// stores indices of first longest substring with K distinct chars
			// to have last longest substring with K distinct chars use end - start + 1 >= maxLen
		    }
	    //}
            //maxLen = Math.max(maxLen, end - start + 1);
        }
        //System.out.println(startIndex+" "+endIndex);
        return maxLen;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		System.out.println(longestSubStringWithAtmostKDistinctChars(str, k));
	}
}
/*
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
*/
