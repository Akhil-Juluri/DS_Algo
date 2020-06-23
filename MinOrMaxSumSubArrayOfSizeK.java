/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int maxSumSubarrayOfSizeK(int nums[], int k) {
        if (nums.length < k) {
            return Integer.MIN_VALUE;
        }
        int start = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            if (end >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum-=nums[start++];
            }
        }
        return maxSum;
    }
    public static int minSumSubarrayOfSizeK(int nums[], int k) {
        if (nums.length < k) {
            return Integer.MAX_VALUE;
        }
        int start = 0, sum = 0, minSum = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            if (end >= k - 1) {
                minSum = Math.min(minSum, sum);
                sum-=nums[start++];
            }
        }
        return minSum;
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
		int k = sc.nextInt();
		System.out.println(maxSumSubarrayOfSizeK(nums, k));
		System.out.println(minSumSubarrayOfSizeK(nums, k));
	}
}
