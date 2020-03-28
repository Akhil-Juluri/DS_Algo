/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int count = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int A[] = {4,3,5,2,1}, sum = 6, curr_sum = 0;
		int R[] = new int[A.length];
		findSubsets(A,A.length,sum,curr_sum, R);
		System.out.println(count);
	}
	public static void findSubsets(int A[], int n, int sum, int curr_sum, int R[]) {
	    if (n == 0) {
	        if (sum == curr_sum) {
	            count++;
	            /*ArrayList<Integer> subSet = new ArrayList<Integer>();
	            for (int i = 0; i < R.length; i++) {
	                if (R[i] != 0) {
	                   subSet.add(R[i]);
	                }
	            }
	            System.out.println(subSet);*/
	        }
	        return;
	    }
	    R[n-1] = 0;
	    findSubsets(A,n-1,sum,curr_sum,R);
	    curr_sum = curr_sum + A[n-1];
	    R[n-1] = A[n-1];
	    findSubsets(A,n-1,sum,curr_sum,R);
	}
}
