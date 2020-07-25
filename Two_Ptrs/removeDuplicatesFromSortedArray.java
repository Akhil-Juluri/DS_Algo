/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right-1]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
		    arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int newLength = removeDuplicatesFromSortedArray(arr);
		System.out.println(newLength);
		for (int i = 0; i < newLength; i++) {
		    System.out.print(arr[i]+" ");
		}
	}
}
