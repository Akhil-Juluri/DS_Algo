public class Solution {
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<Integer> cols = new ArrayList<Integer>();
	    ArrayList<ArrayList<String>> finalRes = new ArrayList<ArrayList<String>>();
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    solveNQ(a, 0, cols, res);
	    //System.out.println("main res "+res);
	    for (int i = 0; i < res.size(); i++) {
	        ArrayList<String> str = new ArrayList<String>();
	        for (int j = 0; j < a; j++) {
	            int value = res.get(i).get(j);
	            StringBuilder s = new StringBuilder();
    	        for (int k = 0; k < a; k++) {
    	            
    	            if (k == value) {
    	                s.append("Q");
    	            } else {
    	                s.append(".");
    	            }
    	            
    	        }
                str.add(s.toString());
	            //System.out.println(str);
	        }
	        finalRes.add(str);
	        //System.out.println(finalRes);
	    }
	    return finalRes;
	}
	public void solveNQ(int n, int rows, ArrayList<Integer> cols, ArrayList<ArrayList<Integer>> res) {
	    if (rows == n) {
	        res.add(new ArrayList<Integer>(cols));
	        //System.out.println("res "+res);
	    } else {
	        for (int i = 0; i < n; i++) {
	            cols.add(i);
	            //System.out.println(cols);
	            if (isValidPlacement(cols)) {
	                solveNQ(n, rows + 1, cols, res);
	            }
	            cols.remove(cols.size() - 1);
	            //System.out.println(cols);
	        }
	    }
	}
	public boolean isValidPlacement(ArrayList<Integer> cols) {
	    int lastIndex = cols.size() - 1;
	    for (int i = 0; i < lastIndex; i++) {
	        int diffValue = Math.abs(cols.get(i) - cols.get(lastIndex));
	        if (diffValue == 0 || (diffValue == (lastIndex - i)) ) {
	            return false;
	        }
	    }
	    return true;
	}
}
