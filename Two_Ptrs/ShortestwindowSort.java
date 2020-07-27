/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int getLengthOfShortestSubarrayWhichSortsWholeArray(int[] nums) {
       int len = 0, start = -1, end = -1;
       
       int left = 0, right = nums.length - 1;
       while (left < nums.length - 1 && nums[left] <= nums[left+1]) {
           left++;
       }
       /*if (left == nums.length - 1) { // array is sorted
           return 0;
       }*/
       while (right > 0 && nums[right] >= nums[right-1]) {
           right--;
       }
       /*if (right == 0) { // array is sorted
           return 0;
       }*/
       if (left == nums.length - 1 && right == 0) { // to be more strict array is sorted
           return 0;
       }
       
       /* for this [1, 3, 2, 0, -1, 7, 10] till now we have left = 1, right = 4 if we sort
       values between those elements we get [1, -1, 0, 2, 3, 7, 10] which is not sorted
       because the min element in the subarray from 1 to 4 is -1 can come in beginning as elements
       before left can be greater than min element, so we have to move to beginning
       till we find a value less than min, similarly we find max in the subarray and moves till the end
       untill we find a element greater than it and sort that subarray*/
       int subMin = Integer.MAX_VALUE, subMax = Integer.MIN_VALUE;
       for(int i = left; i <= right; i++) {
           subMax = Math.max(subMax, nums[i]);
           subMin = Math.min(subMin, nums[i]);
       }
       
       // move to beginning till we find a element less than subarray min
       while (left > 0 && nums[left - 1] > subMin) {
           left--;
       }
       
       //moves to end untill we find a element greater than subarray max
       while (right < nums.length - 1 && nums[right + 1] < subMax) {
           right++;
       }
       
       start = left; // start of shortest window to be sorted
       end = right; // end of shortest window to be sorted
       len = end - start + 1; // length of shortest window to be sorted
       return len;
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
		int subArrLength = getLengthOfShortestSubarrayWhichSortsWholeArray(arr);
		System.out.println(subArrLength);
	}
}

/*
Example 1:
Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted

Example 2:
Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted

Example 3:
Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted

Example 4:
Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.*/
