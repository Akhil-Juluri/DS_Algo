/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int minSizeSubArrayWithSumGreaterThanOrEqualToS(int nums[], int S) {
        int start = 0, sum = 0, size = nums.length + 1, startIndex = -1, endIndex = -1;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            while (sum >= S) {
                startIndex = start;
                endIndex = end;
                size = Math.min(size, end - start + 1);
                sum-=nums[start++];
            }
        }
        return size;
    }
    
    public static int minSizeSubArrayWithSumEqualToS(int nums[], int S) {
        int start = 0, sum = 0, size = nums.length + 1, startIndex = -1, endIndex = -1;
        for (int end = 0; end < nums.length; end++) {
            sum+=nums[end];
            while (sum >= S) {
                if (sum == S) {
                    startIndex = start;
                    endIndex = end;
                    /*startIndex and endIndex contains last smallest subarray with given sum 
                    to have first smallest subarray use a flag*/
                    size = Math.min(size, end - start + 1);
                }
                sum-=nums[start++];
            }
        }
        return size;
    }
    
    /* Above functions doesn't handle values with negative no.s suppose we have 
    input : nums = 10 2 -2 -20 10, sum = -22
    for above logic sum becomes 10 at beginning which is > -22
    the sum will become 0 which leads the inner while loop to fall in infinte loop 
    until ArrayIndexOutOfBoundsException is encountered so we use hashMap
    with sum as keys and values to be end of indices of that sum such that (0 to i) constitues the sum
    if current_sum == sum we return subarray from index 0 to i
    else if hashMap.contains(current_sum-sum)
    this means suppose if we have an array like 1 2 3 4 5, sum = 7 then
    hashmap contains (curr_sum-index) = 1 - 0, 3 - 1, 6 - 2 now current_sum = 10
    for subarray with sum 7 has to present in given array then a subarry with
    current_sum - sum (10 - 7) = 3, should also be present as a subarray
    from 0 to current_sum - sum index value in hashmap
    i.e then our subarray with sum will be presnt from current_sum - sum index value in hashmap + 1 to i
    */
    public static int minSizeSubArrayWithSumEqualToSWithNegatives(int nums[], int sum) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int current_sum = 0, startIndex = -1, endIndex = -1, size = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            current_sum += nums[i];
            if (current_sum == sum) { // or it can be current_sum - sum == 0 
                // this means subarray sum is starting from 0 to i;
                startIndex = 0;
                endIndex = i;
                size = endIndex + 1;
                return size;
            }
            if (hs.containsKey(current_sum - sum)) {
                startIndex = hs.get(current_sum - sum) + 1;
                endIndex = i;
                size = endIndex - startIndex + 1;
                return size;
            }
            hs.put(current_sum, i);
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
		System.out.println(minSizeSubArrayWithSumEqualToSWithNegatives(nums, sum));
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
