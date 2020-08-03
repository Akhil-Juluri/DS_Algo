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
            /* (end - start + 1) > (maxOnesCount + k) i.e our window size will be (maxOnesCount + k) 
	       (end - start + 1) is our current window size if current size exceeds (maxOnesCount + k)
	       we need to decrement frequency of char at start from hashmap and increment start, 
	       as a result even if our string contains complete  different characters while setting maxLength 
	       it won't be a problem as end - start + 1 > maxLen won't be satisfied as current window size
	       end - start + 1 is decreased by one and maintained to maxLength*/
            if (end - start + 1 > k + maxOnesCount) {
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
