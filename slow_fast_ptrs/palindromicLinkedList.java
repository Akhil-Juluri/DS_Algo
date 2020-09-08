/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalf = head;
        // here we reverse second half which looks like below
        // ex: 1->2->3->2->1
        // 1->2 1->2->3->null
        //    |______|
        // here 2 is still pointing to 3
        ListNode secondHalf = reverse(getMiddleNode(head));
        ListNode copyOfSecondHalf = secondHalf;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        // reverting linked list to initial state
        reverse(copyOfSecondHalf);
        if(secondHalf == null) {
            return true;
        }
        return false;
    }
    
}
