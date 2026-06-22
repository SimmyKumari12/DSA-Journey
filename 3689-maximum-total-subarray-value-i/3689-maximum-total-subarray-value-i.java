class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long ans = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int j = 0; j < nums.length; j++){
            max = Math.max(nums[j],max);
            min = Math.min(nums[j],min);
        }

        for(int i = 0; i < k; i++){
            ans = ans + (max - min);
        }

        return ans;
    }
}