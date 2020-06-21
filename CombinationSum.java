public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int b) {
	    ArrayList<Integer> subSet = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> subSets =  new ArrayList<ArrayList<Integer>>();
		Collections.sort(A);
		findSubsets(A,subSets,subSet,0,b);
		return subSets;
	}
	public static void findSubsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer> > subSets,
	    ArrayList<Integer> subSet, int index, int b) {
	    ArrayList<Integer> tempSubSet = new ArrayList<Integer>(subSet);
        int sum = 0;
        for (int j = 0; j < tempSubSet.size(); j++) {
            
            sum = sum + tempSubSet.get(j);
            
        }
        if (sum == b && !subSets.contains(tempSubSet)) {
            subSets.add(tempSubSet);
        }
        for (int i = index; i < A.size(); i++) {
            subSet.add(A.get(i));
            findSubsets(A, subSets, subSet, i+1, b);
            subSet.remove(subSet.size() - 1);
        }
	}
}
