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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevLast = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevLast != null) prevLast.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverseLinkedList(temp); // no need of newHead reference, can check with kthNode but this is expected for clarity
            if(temp == head){
                head = newHead;
                // head = kthNode;
            }else{
                prevLast.next = newHead;
                // prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }

    private ListNode getKthNode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            --k;
            temp = temp.next;
        }
        return temp;
    }

    private ListNode reverseLinkedList(ListNode head){
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