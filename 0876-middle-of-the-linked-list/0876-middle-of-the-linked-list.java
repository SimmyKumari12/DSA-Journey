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
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int len = findLength(head);

        int mid = len/2;

        for(int i = 0; i < mid; i++){
            curr = curr.next;
        }

        head = curr;
        
        return head;
    }

    public int findLength(ListNode head){
        ListNode curr = head;
        int count = 0;

        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}