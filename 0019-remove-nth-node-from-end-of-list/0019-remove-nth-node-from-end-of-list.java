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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);
        int pos = size - n;
        ListNode curr = head;

        if(size == 1){
            return null;
        }

        if(pos == 0){
            return curr = curr.next;
        }

        for(int i = 0; i < pos - 1; i++){
            curr = curr.next;
        }

        if(curr.next.next != null){
            curr.next = curr.next.next;
        } else{
            curr.next = null;
        }

        return head;
    }

    public int length(ListNode head){
        int count = 0;
        ListNode curr = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        return count;
    }
}