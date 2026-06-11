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
        ListNode headA_start = headA;
        ListNode headB_start = headB;
        
        while (headA != headB) {
            if (headA == null) {
                headA = headB_start;
            } else {
                headA = headA.next;
            }

            if (headB == null) {
                headB = headA_start;
            } else {
                headB = headB.next;
            }
        }
        return headA;
    }
}