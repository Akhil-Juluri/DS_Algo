/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    
    /* returns a triplet with sum close to target 
    if some triplets triplets has same closer difference value,
    then return sum of triplet with lesser sum
    example input 50 40 5 15 target = 100 then 
    50+40+5 = 95 closer to 100 with a value of 5
    50+40+15 = 105 also same closer to 100 but with a value of -5
    in this case return 95 as our answer */
    public static int getAnyTripletSumCloserToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int diff = target - nums[i] - nums[left] - nums[right]; // t-(x+y+z) could also be done but it may cause overflow
                
                if (diff == 0) {
                    return target;
                }
                /* Above case can be ignored as it will be handled in below code 
                the advantage of having above code is we reduce further execution of instructions
                and it means that we got a triplet with exact sum of target and there can be no more further best value*/
                if (Math.abs(diff) < Math.abs(minDiff)
                    || ( Math.abs(diff) == Math.abs(minDiff) && diff > minDiff ) ) {
                    minDiff = diff;
                }
                /* In above case when abs differences are equals 
                i.e 50+40+15 = 105 also same closer to 100 but with a value of -5, minDiff = -5
                50+40+5 = 95 closer to 100 with a value of 5, diff = 5
                abs(5) == abs(-5) in this we check if diff > minDiff i.e (5 > -5)
                this means that diff is positive that is from t-(x+y+z) the
                t is larger than the sum of x+y+z and since we want sum of smaller pair
                we do minDiff = diff, now minDiff = 5, which finally returns 100 - 5 = 95*/
                
                if (diff > 0) {
                    // this means we need triplet with higher sum
                    // higher the sum, lesser the difference
                    // lesser the difference then only triptlet sum is closer to target
                    left++;
                } else {
                    // this means we need triplet with lesser sum
                    // lesser the sum, lesser the difference
                    // lesser the difference then only triptlet sum is closer to target
                    right--;
                }
            }
        }
        return target - minDiff;
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
		int res= getAnyTripletSumCloserToTarget(arr, target);
		System.out.println(res);
	}
}
