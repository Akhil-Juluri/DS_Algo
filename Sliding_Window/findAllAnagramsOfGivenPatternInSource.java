/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    // Anagram is nothing but a permutation of a string i.e we have to find how many permutations of
    // pattern are present in source i.e return starting indices of all those permutations
    public static ArrayList findAllAnagramsOfGivenPatternInSource(String source, String pattern) {
        int n = source.length(), k = pattern.length();
        ArrayList<Integer> startIndices = new ArrayList<>();
        if (n < k) {
            return startIndices;
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
                //startIndex = end - k + 1; // end - k + 1 == start so we can use start also // storing startIndex of any permutation of the pattern in source
		        startIndex = start;
		        startIndices.add(startIndex);
                //System.out.println(startIndex+"  "+endIndex);
                
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
        return startIndices;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String source = sc.next();
		String pattern = sc.next();
		System.out.println(findAllAnagramsOfGivenPatternInSource(source, pattern));
	}
}

/*
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
*/
