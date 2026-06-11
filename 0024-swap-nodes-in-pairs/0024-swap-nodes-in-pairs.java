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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next, second = prev.next.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first; // move 2
        }
        return dummy.next;
    }
}