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
    public int pairSum(ListNode head) {
        ListNode curr = head;
        int n = 0;
        while(curr != null){
            curr = curr.next;
            n++;
        }

        ListNode temp = head;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = temp.val;
            temp = temp.next;
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n/2;i++){
            int sum = 0;
            sum += res[i] + res[n-1-i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}