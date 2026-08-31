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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int count = 1;
        ArrayList<Integer> val = new ArrayList<>();
        int[] ans = new int[2];
        Arrays.fill(ans,-1);

        while(curr.next != null){
            //Local Minima
            if(prev.val > curr.val && curr.val < curr.next.val){
                val.add(count);
            } else if(prev.val < curr.val && curr.val > curr.next.val){
                val.add(count);
            }
            prev = prev.next;
            curr = curr.next;
            count++;
        }

        int n = val.size();
        if(n < 2){
            return ans;
        }

        Collections.sort(val);
        int minDist = Integer.MAX_VALUE;
        int maxDist = val.get(n - 1) - val.get(0);

        for(int i = 1; i < n; i++){
            int num = val.get(i) - val.get(i - 1);
            minDist = Math.min(minDist,num);
        }

        ans[0] = minDist;
        ans[1] = maxDist;
        return ans;
    }
}