/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int getTripletsCountSmallerThanTarget(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length - 1;
            int diff = target - nums[i]; // x+y+z < target => y+z < target - x => diff = target - x;
            while (left < right) {
                int val = nums[left] + nums[right];
                if (val < diff) { // y+z < diff
                    count+= right - left;
                    /* this means that if we have input : 4 5 6 7 8 and target = 22
                    diff = 22 - 4 = 18, val = 5 + 8 = 13, 13 < 18 then obviosly any number
                    which are less than 8 are added to 5 like 5+7, 5+6 will definitely gives
                    value less than diff i.e there will not effect on the val, so we keep 4,5
                    as two fixed values in my triplets and include values between left and right
                    as another number along with 4,5 like 4,5,(6) | 4,5,(7) | 4,5,(8) 
                    here we have 3 triplets which we get as right - left = 4 - 1 = 3 
                    and we increment left because we saw that 
                    decrementing right doesn't have any effect on the value*/
                    for (int j = left + 1; j <= right; j++) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[j]);
                        triplets.add(triplet);
                    }
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(triplets); // contains all triplets whose sum is smaller than target
        return count;
    }
    public static int getTripletsCountLargerThanTarget(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length - 1;
            int diff = target - nums[i]; // x+y+z > target => y+z > target - x => diff = target - x;
            while (left < right) {
                int val = nums[left] + nums[right];
                if (val > diff) { // y+z > diff
                    count+= right - left;
                    /* this means that if we have input : 4 5 6 7 8 and target = 3
                    diff = 3 - 4 = -1, val = 5 + 8 = 13, 13 > -1 then obviosly any number
                    which are greater than 5 are added to 8 like 6+8, 7+8 will definitely gives
                    value greater than diff i.e there will not effect on the val, so we keep 4,8
                    as two fixed values in my triplets and include values between left and right
                    as another number along with 4,8 like 4,(5),8 | 4,(6),8 | 4,(7),8 
                    here we have 3 triplets which we get as right - left = 4 - 1 = 3 
                    and we decrement right because we saw that 
                    incrementing left doesn't have any effect on the value*/
                    for (int j = right - 1; j >= left; j--) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[right]);
                        triplets.add(triplet);
                    }
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(triplets); // contains all triplets whose sum is larger than target
        return count;
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
		int count1 = getTripletsCountSmallerThanTarget(arr, target);
		int count2 = getTripletsCountLargerThanTarget(arr, target);
		System.out.println(count1);
		System.out.println(count2);
	}
}
