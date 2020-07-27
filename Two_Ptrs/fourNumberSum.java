/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static List<List<Integer>> getAllQuadruplesSumToTargetWithHashMap(int[] nums, int target) {
        List<List<Integer>> Quadruples = new ArrayList<>();
        HashMap<Integer, List<List<Integer>>> diffMap = new HashMap<>();
        HashMap<String, Integer> uniqueQuadruples = new HashMap<>();
        
        /* inside first loop checks for a pair of c and d which matches t - a - b 
        second loop adds c and d sum of all pairs to the map say if we have second loop at first 
        then there will be addition of duplicate values so we first check then add pair sums to diffMap*/
        for (int i = 0; i < nums.length; i++) {
            
            // a+b+c+d = t => b+c+d = t - a => diff
            int diff = target - nums[i];
            
            // below loop is for finding c and d values comparing c+d with t-a-b
            for (int j = i+1; j < nums.length; j++) {
                
                // b+c+d = t - a => c+d = t - a - b => againDiff
                int againDiff = diff - nums[j];
                
                /* if againDiff is present in HashMap it means we already got a pair of c, d 
                equals to againDiff, we will fetch all those pair of c and d values from HashMap
                and append all of them with a, b here nums[i] and nums[j] and add to Quadruples list*/
                if (diffMap.containsKey(againDiff)) {
                    
                    List<List<Integer>> pairs = diffMap.get(againDiff);
                    
                    // O(n) in worst case when elements are 1 1 1 1 1 and target = 4 then all Quadruples gives sum 4
                    for (int l = 0; l < pairs.size(); l++) {
                        
                        List<Integer> Quadruple = new ArrayList<Integer>();
                        
                        int a = pairs.get(l).get(0);
                        int b = pairs.get(l).get(1);
                        int c = nums[i]; int d = nums[j];
                        Quadruple.add(a); Quadruple.add(b); Quadruple.add(c); Quadruple.add(d);
                        
                        // constant time as only 4 values
                        Collections.sort(Quadruple);
                        
                        // after sorting if we same string again then it is a duplicate entry
                        if (!uniqueQuadruples.containsKey(Quadruple.toString())) {
                            Quadruples.add(Quadruple);
                            uniqueQuadruples.put(Quadruple.toString(), 0); // add 0 as dummy value
                        }
                    }
                }
            }
            
            /* below loop is to add c+d nothing but differnce values for t-a-b
            it adds every pair sum in the diffMap these needs to be compared against againDiff*/
            for (int  k = 0; k < i; k++) {
                
                int sum = nums[i] + nums[k];
                
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(nums[i]);
                pair.add(nums[k]);
                
                if (diffMap.containsKey(sum)) {
                    List<List<Integer>> pairs = diffMap.get(sum);
                    pairs.add(pair);
                } else {
                    diffMap.put(sum, new ArrayList<>());
                    List<List<Integer>> pairs = diffMap.get(sum);
                    pairs.add(pair);
                }
            }
        }
        //System.out.println(diffMap);
        //System.out.println(Quadruples);
        //System.out.println(uniqueQuadruples);
        return Quadruples;
    }
    
    
    public static List<List<Integer>> getAllQuadruplesSumToTargetWithSorting(int[] nums, int target) {
        List<List<Integer>> Quadruples = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            
            // since array is sorted this is how we avoid duplicate elements
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // a+b+c+d = t => b+c+d = t - a => diff
            int diff = target - nums[i];
            
            for (int j = i+1; j < nums.length; j++) {
                // since array is sorted this is how we avoid duplicate elements
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                
                // b+c+d = t - a => c+d = t - a - b => againDiff
                int againDiff = diff - nums[j];
                
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == againDiff) {
                        Quadruples.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    } else if (sum < againDiff) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            
            
        }
        return Quadruples;
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
		List<List<Integer>> Quadruples = getAllQuadruplesSumToTargetWithHashMap(arr, target);
		System.out.println(Quadruples);
		Quadruples = getAllQuadruplesSumToTargetWithSorting(arr, target);
		System.out.println(Quadruples);
	}
}

/*
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.

Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.*/
