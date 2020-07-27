/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    /* since strings containf backspace characters we travel from back of strings
    and find the index of the character from back after skipping all backspaces 
    and characters at those indices should be equal in both strings else return false*/
    public static boolean isStringsWithBackspacesAreEqual(String one, String two) {
        
       int index1 = one.length() - 1, index2 = two.length() - 1;
       while (index1 >= 0 && index2 >= 0) {
           
           index1 = getLastValidCharIndex(one, index1);
           index2 = getLastValidCharIndex(two, index2);
           
           // two strings are completed with all chars are equal after ignoring backspaces
           if (index1 < 0 && index2 < 0) {
               return true;
           }
           
           // one of the strings are completed but other still has chars so they ar enot equal
           if (index1 < 0 || index2 < 0) {
               return false;
           }
           
           // strings are not empty and chars at that indices are not equal so it is false
           if (one.charAt(index1) != two.charAt(index2)) {
               return false;
           }
           
           index1--;
           index2--;
       }
       return true;
    }
    
    public static int getLastValidCharIndex(String str, int i) {
        int backspaces = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                backspaces++; // incrementing if it is backspace
            } else if (backspaces > 0) {
                backspaces--; // if it is other char and backspaces are > 0 ignore it
            } else { // else it is a different character which needs to be compared 
                return i;
            }
            i--; // shrinking the string
        }
        return i;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String one = sc.next();
		String two = sc.next();
		boolean isEqual = isStringsWithBackspacesAreEqual(one, two);
		System.out.println(isEqual);
	}
}
/*
Example 1:
Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Example 2:
Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Example 3:
Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Example 4:
Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.*/
