class Solution {
    int dp[][];
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i : nums){
            total += i;
        }

        dp = new int[n + 1][n + 1];

        for(int[] a : dp){
            Arrays.fill(a,-1);
        }

        int p1 = solve(0,n - 1,nums);
        int p2 = total - p1;

        return p1 >= p2;
    }

    public int solve(int start, int end , int[] nums){
        if(start == end){
            return nums[start];
        }

        if(start > end){
            return 0;
        }

        //Player1 has either two choices choose either nums[start] or nums[end]
        //If he picked start then
        int pickStart = nums[start] + Math.min(solve(start + 2, end , nums),solve(start + 1, end - 1, nums));

        //If he picked end then
        int pickEnd = nums[end] + Math.min(solve(start + 1, end - 1, nums),solve(start,end - 2, nums));

        return dp[start][end] = Math.max(pickStart,pickEnd);
    }
}