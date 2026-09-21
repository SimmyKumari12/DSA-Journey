class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int idx = 0;

        for(int num : nums){
            ans[idx++] = num;
        }

        for(int num : nums){
            ans[idx++] = num;
        }

        return ans;
    }
}