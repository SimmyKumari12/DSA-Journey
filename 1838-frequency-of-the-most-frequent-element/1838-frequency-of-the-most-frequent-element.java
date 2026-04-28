class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int maxFreq = 0;
        int n = nums.length;
        int l = 0, r = 0;

        for(r = 0; r < n; r++){
            total = total + nums[r];

            while((long) nums[r] * (r - l + 1) > total + k){
                total = total - nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }
        return maxFreq;
    }
}