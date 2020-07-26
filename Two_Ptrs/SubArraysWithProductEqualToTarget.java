/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static List<List<Integer>> getAllSubArraysWithProductEqualToTarget(int[] nums, int target) {
        List<List<Integer>> resArr = new LinkedList<>();
        int count = 0, first = 0, product = 1;
        for (int last = 0; last < nums.length; last++) {
            
            product = product * nums[last];
            
            while (product > target && first <= last) {
                product = product / nums[first];
                first++;
            }
            
            if (product == target) {
                int ones = 1;
                while(first <= last && nums[first] == 1) {
                    first++;
                    ones++;
                }
                count+=ones; // if we have any ones we will add else we will add 1 considering current subarray
                while(last + 1 < nums.length && nums[last + 1] == 1) {
                    last++;
                    count+=ones;
                }
                product = product / nums[first];
                first++;
                /*example input : 1 2 3 1 1 4 5, target = 6
                when first = 0 and last = 2 product = 6, we know 1 2 3 is one subarray
                and also 2, 3 is also a valid answer for that we have to count the preceding 1
                as in product 1 has no effect but leads to a valid answer
                so we count preceding one's i.e here preceding one's are 1
                but we initialize ones to 1 because we know that 1,2,3 and 2,3 are valid
                subarrays for preceding 1's since 2,3 is also we initialize ones to 1
                and when finding suceeding ones we will increment count by ones because
                for every 1,2,3 and 2,3 every suceedingone forms a valid subarray
                like 1,2,3,1 || 1,2,3,1,1 and 2,3,1 || 2,3,1,1 */
            }
        }
        System.out.println(count);
        return resArr;
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
		int target = sc.nextInt();
		List<List<Integer>> subArrays = getAllSubArraysWithProductEqualToTarget(arr, target);
		System.out.println(subArrays);
	}
}
