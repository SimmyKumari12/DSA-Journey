class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int res = 0;
        int countZeroes = 0;

        for(int end = 0; end < n; end++){
            if(nums[end] == 0){
                countZeroes++;
            }

            while(countZeroes > k){
                if(nums[start] == 0){
                    countZeroes--;
                }
                start++;
            }
            res = Math.max(res,end - start + 1);
        }

        return res;
    }
}