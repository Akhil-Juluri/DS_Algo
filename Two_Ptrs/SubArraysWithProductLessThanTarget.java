/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static List<List<Integer>> getAllSubArraysWithProductLessThanTarget(int[] nums, int target) {
        List<List<Integer>> resArr = new LinkedList<>();
        int count = 0, first = 0, product = 1;
        for (int last = 0; last < nums.length; last++) {
            product = product * nums[last];
            while (product >= target && first <= last) {
                product = product / nums[first];
                first++;
            }
            count+= last - first + 1;
            List<Integer> subArr = new LinkedList<>();
            for (int i = last; i >= first; i--) {
                subArr.add(0,nums[i]);
                System.out.println(subArr);
                resArr.add(new LinkedList<>(subArr));
            }
            /* for example nums[] = 1 2 3 4 5, target = 121
            and we are at last element at 5 then product = 120 which is < 121
            so we need to add [5] [4, 5] [3, 4, 5] [2, 3, 4, 5] [1, 2, 3, 4, 5] in resArr
            so we took LinkedList and have to start with last element till first element 
            since we have to maintain the order we have to add elements before 5 in the List
            if we would have taken arraylist instead of LinkedList inserting at front take O(n) time
            so we took LinkedList and we have added it to front and have to create a new list Object
            and add to resArr to avoid duplicates*/
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
		List<List<Integer>> subArrays = getAllSubArraysWithProductLessThanTarget(arr, target);
		System.out.println(subArrays);
	}
}
