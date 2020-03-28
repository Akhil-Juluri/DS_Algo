/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
  public static ArrayList<ArrayList<Integer> > subSets =  new ArrayList<ArrayList<Integer> >(); 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int A[] = {3,2,1};
		int R[] = new int[A.length];
		subSets.clear();
		findSubsets(A,A.length,R);
		System.out.println(subSets);
	}
	public static void findSubsets(int A[], int n, int R[]) {
	    if (n == 0) {
	        ArrayList<Integer> subSet = new ArrayList<Integer>();
	        for (int i = 0; i < R.length; i++) {
	            if (R[i] != 0) {
	                subSet.add(R[i]);
	            }
	        }
	        subSets.add(subSet);
	        return;
	    }
	    R[n-1] = 0;
	    findSubsets(A,n-1,R);
	    R[n-1] = A[n-1];
	    findSubsets(A,n-1,R);
	}
}
