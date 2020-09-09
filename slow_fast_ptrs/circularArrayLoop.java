class Solution {
    
    public int findNextIndex(int[] nums,int i,boolean actualDirection) {
        boolean direction = (nums[i] >= 0);
        
        // check if the direction we are moving is equal to the actual direction
        // since it is not possible for a cycle in both directions we return -1
        if (direction != actualDirection) { 
            return -1;
        }
        
        int index = (i + nums[i]) % nums.length;
        
        if (index < 0) { // if negative find position from reverse by adding length of array
            index+=nums.length;
        }
        
        // this means the index we are jumping is equal to same index i.e a loop
        if (index == i) {
            return -1;
        }
        return index;
    }
    
    public boolean circularArrayLoop(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            
            boolean direction = (nums[i] >= 0); // we are moving forward
            int slow = i, fast = i;
            do {
                slow = findNextIndex(nums, slow, direction);
                fast = findNextIndex(nums, fast, direction);
                if (fast != -1) {
                    fast = findNextIndex(nums, fast, direction);
                }
            } while (slow != -1 && fast != -1 && slow != fast);
            
            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }
}
