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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;

        head = reverse(head);
        ListNode curr = head;
        int maxVal = curr.val;
        while(curr != null && curr.next != null){
            if(curr.next.val < maxVal){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
                maxVal = curr.val;
            }
        }
        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}