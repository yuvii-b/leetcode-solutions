/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA, curr2 = headB;
        int n1 = 0, n2 = 0, diff = 0;
        while(curr1 != null){
            ++n1;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            ++n2;
            curr2 = curr2.next;
        }
        curr1 = headA;
        curr2 = headB;
        if(n1 > n2){
            diff = n1 - n2;
            while(diff --> 0) curr1 = curr1.next;
        }else{
            diff = n2 - n1;
            while(diff --> 0) curr2 = curr2.next;
        }
        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }
}