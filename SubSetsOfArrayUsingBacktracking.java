public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> subSet = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> subSets =  new ArrayList<ArrayList<Integer>>();
		Collections.sort(A);
		findSubsets(A,subSets,subSet,0);
		return subSets;
    }
    public static void findSubsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer> > subSets,
	ArrayList<Integer> subSet, int index) {
	    ArrayList<Integer> tempSubSet = new ArrayList<Integer>(subSet);
        subSets.add(tempSubSet);
        for (int i = index; i < A.size(); i++) {
            subSet.add(A.get(i));
            findSubsets(A, subSets, subSet, i+1);
            subSet.remove(subSet.size() - 1);
        }
    }
}
