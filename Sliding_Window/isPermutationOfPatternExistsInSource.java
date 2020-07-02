/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static boolean isPermutationOfPatternExistsInSource(String source, String pattern) {
        int n = source.length(), k = pattern.length();
        if (n < k) {
            return false;
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
        int start = 0, startIndex = -1, endIndex = -1, continuous = 0;
        for (int end = 0; end < n; end++) {
            char ch = source.charAt(end);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch)-1);
                if (hm.get(ch) == 0) {
                    continuous++;
                }
            }
            if (continuous == hm.size()) {
                endIndex = end; // storing endIndex of any permutation of the pattern in source
                startIndex = end - k + 1; // storing startIndex of any permutation of the pattern in source
                //System.out.println(startIndex+"  "+endIndex);
                return true;
            }
            if (end >= k - 1) {
                char c = source.charAt(start);
                if (hm.containsKey(c)) {
                    if (hm.get(c) == 0) {
                        continuous--;
                    }
                    hm.put(c,hm.get(c)+1);
                }
                start++;
            }
        }
        return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String source = sc.next();
		String pattern = sc.next();
		System.out.println(isPermutationOfPatternExistsInSource(source, pattern));
	}
}

/*
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
*/
