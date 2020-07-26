/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    // dutch national flag problem
    public static int[] sortZerosOnesTwos(int[] arr) {
        int first = 0, mid = 0, last = arr.length; 
        // if last = arr.length - 1 then while (mid <= last) and last-- will be last step in last if when arr[i] == 2
        while (mid < last) {
            if (arr[mid] == 0) {
                // if we see any 0 at mid we will swap it with the first position moving all zeros to first
                int temp = arr[mid];
                arr[mid] = arr[first];
                arr[first] = temp;
                first++;
                mid++;
                // we increment both first and mid as we are sure that first contains 0 or 1 and mid contains 0
                // because even if mid contains 2 it will be swapped with either 1 or 0 from the last
            } else if (arr[mid] == 1) {
                // simply increment mid if it 1 having all 1's in the middle
                mid++;
            } else if (arr[mid] == 2) {
                // if we see any 2 at mid we will swap it with the last position moving all two's to last
                last--;
                int temp = arr[mid];
                arr[mid] = arr[last];
                arr[last] = temp;
                // here we decrement only last and not increment mid as we are not sure 
                //element swapped to mid is definitely 1 it also can be 0
            }
        }
        return arr;
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
		arr = sortZerosOnesTwos(arr);
		for (int i = 0; i < n; i++) {
		    System.out.print(arr[i]+" ");
		}
	}
}
