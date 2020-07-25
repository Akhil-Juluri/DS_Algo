/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static ArrayList<ArrayList<Integer>> getTripletsSumToTarget(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            
            if (i > 0 && nums[i] == nums[i-1]) {
                // if same number then don't consider it to avoid duplicate triplet values
                continue;
            }
            
            int diff = target - nums[i]; // x+y+z = t => y+z = t-x => diff = t-x
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int val = nums[left] + nums[right]; // val = y+z we could also do x+y+z = t but it may cause overflow
                if (val == diff) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]); triplet.add(nums[left]); triplet.add(nums[right]);
                    left++; right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    // if same number then don't consider it to avoid duplicate triplet values
                    while (left < right && nums[right] == nums[right+1]) right--;
                    res.add(triplet);
                } else if (val < diff) {
                    left++;
                } else {
                    right--;
                }
            }
        }
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
		int target = sc.nextInt(); // or
		//int target = 0;
		ArrayList<ArrayList<Integer>> res= getTripletsSumToTarget(arr, target);
		System.out.println(res);
	}
}
/*
9
-3 0 1 2 -1 1 -2 0 -6
-6

o/p : [[-6, -2, 2], [-6, -1, 1], [-6, 0, 0], [-3, -2, -1]]
*/
