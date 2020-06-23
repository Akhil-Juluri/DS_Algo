/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int minSizeSubArrayWithSumGreaterThanOrEqualToS(int nums[], int S) {
        int start = 0, sum = 0, size = nums.length + 1;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            while (sum >= S) {
                size = Math.min(size, end - start + 1);
                sum-=nums[start++];
            }
        }
        return size;
    }
    
    public static int minSizeSubArrayWithSumEqualToS(int nums[], int S) {
        int start = 0, sum = 0, size = nums.length + 1;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            while (sum >= S) {
                if (sum == S) {
                    size = Math.min(size, end - start + 1);
                }
                sum-=nums[start++];
            }
        }
        return size;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
		    nums[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(minSizeSubArrayWithSumGreaterThanOrEqualToS(nums, sum));
		System.out.println(minSizeSubArrayWithSumEqualToS(nums, sum));
	}
}
/*
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
*/
