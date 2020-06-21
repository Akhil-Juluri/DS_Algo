class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer,ArrayList<ArrayList<Integer>>> hm = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<String> hs = new HashSet<String>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            
            int diff = target - nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                
                int againDiff = diff - nums[j];
                
                if (hm.containsKey(againDiff)) {
                    ArrayList<ArrayList<Integer>> allPairs = hm.get(againDiff);
                    for (int l = 0; l < allPairs.size(); l++) {
                        List<Integer> currRes = new ArrayList<Integer>();
                        int a = allPairs.get(l).get(0);
                        int b = allPairs.get(l).get(1);
                        int c = nums[i];
                        int d = nums[j];
                        currRes.add(a); currRes.add(b); currRes.add(c); currRes.add(d);
                        Collections.sort(currRes);
                        String val = currRes.toString();
                        if (!hs.contains(val)) {
                            res.add(currRes);
                            hs.add(val);
                        }
                    }
                    
                }
                
            }
            
            for (int k = 0; k < i; k++) {
                
                int sum = nums[i] + nums[k];
                ArrayList<Integer> pairOne = new ArrayList<Integer>();
                pairOne.add(nums[i]);
                pairOne.add(nums[k]);
                if (hm.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> allPairs = hm.get(sum);
                    allPairs.add(pairOne);
                } else {
                    hm.put(sum,new ArrayList<ArrayList<Integer>>());
                    ArrayList<ArrayList<Integer>> allPairs = hm.get(sum);
                    allPairs.add(pairOne);
                }
            }
            
        }
        //System.out.println(hm);
        return res;
    }
}
