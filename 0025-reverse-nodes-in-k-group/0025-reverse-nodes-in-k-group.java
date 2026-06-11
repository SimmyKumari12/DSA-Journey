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
        //Step1 : Check if we even have k nodes
        ListNode curr = head;
        int count = 0;

        while(curr != null && count < k){
            curr = curr.next;
            count++;
        }

        //If less than k return head
        if(count < k) return head;

        //Step 2 : Reverse K nodes
        ListNode prev = null;
        curr = head;
        ListNode next = null;
        count = 0;

        while(count < k){ // 0 < 3, 1 < 3, 2 < 3
            next = curr.next; //next = 2, next = 3, next = 4
            curr.next = prev; //curr.next = null, curr.next = 1, curr.next = 2
            prev = curr; // prev = 1 // prev = 2, prev = 3
            curr = next; // curr = 2, curr = 3, curr = 4
            count++; // count = 1, count = 2, count = 3
        }

        //3 -> 2 -> 1 -> null

        head.next = reverseKGroup(curr,k); //reverseKGroup(4,2);

        return prev;
    }
}