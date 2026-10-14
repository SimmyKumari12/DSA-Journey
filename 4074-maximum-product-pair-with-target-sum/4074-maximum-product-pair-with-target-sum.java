class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((nums[i] + nums[j] == target) && (nums[i] > nums[j])){
                    int mul = nums[i] * nums[j];
                    if(mul > max){
                        ans[0] = i;
                        ans[1] = j;
                        max = mul;
                    }
                }
            }
        }
        return ans;
    }
}