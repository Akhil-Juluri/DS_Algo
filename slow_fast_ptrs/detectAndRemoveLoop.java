/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getCycleNode(ListNode slow, ListNode fast) {
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void removeLoop(ListNode node) {
        ListNode loopStartNode = node;
        while (node != null && node.next != loopStartNode) {
            node = node.next;
        }
        if (node != null) {
            node.next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode loopStartNode = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopStartNode = getCycleNode(slow, head);
                removeLoop(loopStartNode);
                break;
            }
        }
        ListNode tempHead = head;
        while(tempHead != null) {
            System.out.println(tempHead.val+"  "+tempHead.next);
            tempHead = tempHead.next;
        }
        return loopStartNode;
    }
}
