/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    public static long[] getSquaresOfArray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        long[] squaresArray = new long[n];
        while (left < right) {
            long squareLeft = nums[left] * nums[left];
            long squareRight = nums[right] * nums[right];
            if (squareLeft >= squareRight) {
                squaresArray[--n] = squareLeft;
                left++;
            } else {
                squaresArray[--n] = squareRight;
                right--;
            }
        }
        return squaresArray;
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
		Arrays.sort(arr);
		long[] squaresArray = getSquaresOfArray(arr);
		for (int i = 0; i < squaresArray.length; i++) {
		    System.out.print(squaresArray[i]+" ");
		}
	}
}
