class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZeroes = 0;
        int mul = 1;
        int idx = 0;
        int n = nums.length;
        int[] ans = new int[n];

        while(idx < n){
            if(nums[idx] != 0){
                mul *= nums[idx];
                idx++;
            } else{
                countZeroes++;
                idx++;
            }
        }

        if(countZeroes >= 2){
            Arrays.fill(ans,0);
            return ans;
        } else if(countZeroes == 1){
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    ans[i] = 0;
                } else{
                    ans[i] = mul;
                }
            }
        } else{
            for(int i = 0; i < n; i++){
                ans[i] = mul / nums[i];
            }
        }
        return ans;
    }
}