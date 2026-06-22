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
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = list.size() - 1;
        int sum = 0;
        int maxSum =Integer.MIN_VALUE;

        while(left < right){
            sum = list.get(left) + list.get(right);
            maxSum = Math.max(sum,maxSum);
            left++;
            right--;
        }
        return maxSum;
    }
}