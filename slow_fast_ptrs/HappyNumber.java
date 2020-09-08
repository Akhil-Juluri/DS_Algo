class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(slow != fast);
        return slow == 1;
    }
    public int findSquare(int num) {
        int res = 0;
        while (num != 0) {
            res += Math.pow((num % 10), 2);
            num/=10;
        }
        return res;
    }
}
