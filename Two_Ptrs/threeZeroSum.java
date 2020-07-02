public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1, k = nums.size() - 1;
            long x = nums.get(i);
            while (j < k) {
                long y = nums.get(j);
                long z = nums.get(k);
                long sum = x + y + z;
                if (sum == 0) { // or we could also check for y + z == -x because if x + y + z = 0 then y + z = 0 - x = -x
                    ArrayList<Integer> currRes = new ArrayList<Integer>();
                    currRes.add(nums.get(i));
                    currRes.add(nums.get(j));
                    currRes.add(nums.get(k));
                    String val = currRes.toString();
                    if (!hs.contains(val)) {
                        res.add(currRes);
                        hs.add(val);
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }
        return res;
    }
}
