public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        temp.add(A.get(0));
        
        res.add(temp);
        
        for (int i = 1; i < A.size(); i++) {
            
            for (int j = 0; j < res.size(); j++) {
                
                ArrayList<Integer> use = new ArrayList<Integer>();
                
                use.addAll(res.get(j));
                
                for(int k = 0; k < use.size()+1; k++) {
                    
                    ArrayList<Integer> swap = new ArrayList<Integer>();
                    
                    for(int l = 0; l < use.size(); l++) {
                        
                        if (k == l) {
                            swap.add(A.get(i));
                        }
                        swap.add(use.get(l));
                    }
                    if (k == use.size()) {
                        swap.add(A.get(i));
                    }
                    finalRes.add(swap);
                    //System.out.println(finalRes);
                }
                
            }
            res.clear();
            res.addAll(finalRes);
            finalRes.clear();
        }
        return res;
    }
}
