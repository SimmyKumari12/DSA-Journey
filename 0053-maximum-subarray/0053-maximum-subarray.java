class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum = Math.max(nums[i],nums[i] + sum);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}