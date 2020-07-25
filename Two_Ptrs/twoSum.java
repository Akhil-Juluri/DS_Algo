/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static ArrayList<ArrayList<Integer>> twoSumForUnsortedArray(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Integer> hs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.containsKey(target - nums[i])) {
                ArrayList<Integer> subArr = new ArrayList<Integer>();
                subArr.add(hs.get(target - nums[i]));
                subArr.add(i);
                resArr.add(subArr);
            } else {
                hs.put(nums[i],i);
            }
        }
        //System.out.println(resArr);
         // return indices of all pairs that adds to target
        return resArr;
    }
    public static ArrayList<Integer> twoSumForSortedArray(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int left = 0, right = nums.length - 1, sum = 0;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(nums[left]);
                res.add(nums[right]);
                return res;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // returns a single pair of values that adds to target or empty if no such pair exists
        return res;
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
		ArrayList<ArrayList<Integer>> res = twoSumForUnsortedArray(arr, target);
		System.out.println(res);
		Arrays.sort(arr);
		ArrayList<Integer> res1 = twoSumForSortedArray(arr, target);
		System.out.println(res1);
	}
}
