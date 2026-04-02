class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int n = nums.length;

        if(n == 1){
            return nums[n-1];
        }

        for(int x : nums){
            currSum += x;
            maxSum = Math.max(currSum,maxSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}