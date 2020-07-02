/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int longestSubStringWithOnesAfterReplacingWithAtmostKOnes(String str, int k) {
        int start = 0, maxLen = 0, startIndex = -1, endIndex = -1, maxOnesCount = 0;
        for(int end = 0; end < str.length(); end++) {
            if (str.charAt(end) == '1') {
                maxOnesCount++;
            }
            // end - start + 1 - maxOnesCount > k means that in the window from start to end,
            // even if we remove the count of max rep char and even after adding extra k chars
            // still one extra char got added to the desired so we subtract it from start
            if (end - start + 1 - maxOnesCount > k) {
                if(str.charAt(start) == '1') {
                    maxOnesCount--;
                }
                start++;
            }
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                startIndex = start;
                endIndex = end;
                // stores indices of first longest SubString With Ones After Replacing With Atmost K Ones
                // to have last longest SubString With Ones After Replacing With Atmost K Ones use end - start + 1 >= maxLen
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
		int k = sc.nextInt();
		System.out.println(longestSubStringWithOnesAfterReplacingWithAtmostKOnes(str, k));
	}
}
