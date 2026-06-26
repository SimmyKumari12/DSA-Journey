class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < n; j++){
                min = Math.min(nums[j],min);
                max = Math.max(nums[j],max);

                sum = sum + (max - min);
            }
        }
        return sum;
    }
}