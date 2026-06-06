class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int lS = 0;
        int[] rightSum = new int[n];
        int rS = 0;
        int[] ans = new int[n];

        //Left Sum
        leftSum[0] = 0;
        for(int i = 1; i < n; i++){
            lS = lS + nums[i - 1];
            leftSum[i] = lS;
        }

        //RightSum
        rightSum[n-1] = 0;
        for(int i = n - 2; i >= 0; i--){
            rS = rS + nums[i + 1];
            rightSum[i] = rS;
        }

        //Absolute leftSum - rightSum
        for(int i = 0; i < n; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}