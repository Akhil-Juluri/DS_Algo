/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static int removeAllInstancesOfKey(int[] nums, int key) {
        int left = -1;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != key) {
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
		int key = sc.nextInt();
		// array need not be sorted
		int newLength = removeAllInstancesOfKey(arr, key);
		System.out.println(newLength);
		for (int i = 0; i < newLength; i++) {
		    System.out.print(arr[i]+" ");
		}
	}
}
