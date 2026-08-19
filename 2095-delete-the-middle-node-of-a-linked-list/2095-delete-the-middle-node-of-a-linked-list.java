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
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        if(head == null || head.next == null){
            return null;
        }

        ListNode curr = head;
        int count = 1;

        while(curr.next != null){
            curr = curr.next;
            count++;
        }

        ListNode temp = head;
        int mid = count / 2;
        int ctr = 0;
        
        while(temp != null && temp.next != null){
            if(ctr + 1 == mid){
                temp.next = temp.next.next;
            }
            temp = temp.next;
            ctr++;
        }
        return head;
    }
}