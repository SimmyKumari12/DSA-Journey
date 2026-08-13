class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int start = 0;
        int countZeroes = 0;

        for(int end = 0; end < n; end++){
            if(nums[end] == 0){
                countZeroes++;
            }

            while(countZeroes >= 2){
                if(nums[start] == 0){
                    countZeroes--;
                }
                start++;
            }

            res = Math.max(res,end - start);
        }
        return res;
    }
}