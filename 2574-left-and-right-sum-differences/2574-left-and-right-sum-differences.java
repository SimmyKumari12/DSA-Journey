class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int ls = 0;
        int rs = 0;

        for(int num : nums){
            rs = rs + num;
        }

        for(int i = 0; i < n; i++){
            rs = rs - nums[i];
            ans[i] = Math.abs(ls - rs);
            ls = ls + nums[i];
        }

        return ans;
    }
}