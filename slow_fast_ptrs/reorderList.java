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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode tempHead = head;
        while (tempHead != null) {
            ListNode temp = tempHead.next;
            tempHead.next = prev;
            prev = tempHead;
            tempHead = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(getMiddleNode(head));
        while (firstHalf != null && secondHalf != null) {
            ListNode tempFirst = firstHalf.next;
            firstHalf.next = secondHalf;
            
            ListNode tempSecond = secondHalf.next;
            secondHalf.next = tempFirst;
            
            firstHalf = tempFirst;
            secondHalf = tempSecond;
        }
        // removing the loop if no. of elements are even
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }
}
