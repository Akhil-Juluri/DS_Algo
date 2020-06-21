public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> subSets =  new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lastEle = new ArrayList<Integer>();
		if (A.size() == 0) {
		    ArrayList<Integer> emptySet = new ArrayList<Integer>();
		    subSets.add(emptySet);
		    return subSets;
		}
		Collections.sort(A);
		lastEle.add(A.get(A.size() - 1));
		subSets.add(lastEle);
		for (int i = A.size() - 2; i >= 0; i--) {
		    int len = subSets.size();
		    //System.out.println(len);
		    for (int j = 0; j < len; j++) {
		        ArrayList<Integer> subSet = new ArrayList<Integer>();
		        subSet.add(A.get(i));
		        //System.out.println(subSet);
		        subSet.addAll(subSets.get(j));
		        //System.out.println(subSet);
		        subSets.add(subSet);
		        //System.out.println(subSets);
		    }
		    ArrayList<Integer> subSet = new ArrayList<Integer>();
		    subSet.add(A.get(i));
		    subSets.add(subSet);
		}
		ArrayList<Integer> emptySet = new ArrayList<Integer>();
		subSets.add(emptySet);
		Collections.reverse(subSets);
		return subSets;
    }
}
/* 
input : 1 2 3

output:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
*/
