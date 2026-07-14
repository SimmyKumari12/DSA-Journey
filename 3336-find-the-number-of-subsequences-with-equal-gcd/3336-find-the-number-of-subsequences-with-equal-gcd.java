class Solution {
    private static int mod = 1000000007;
    private int n;
    private int[][][] dp;

    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][201][201];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= 200; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(nums,0,0,0);
    }

    public int solve(int[] nums, int idx, int first, int second){
        if(idx == n){
            return (first!= 0 && first == second) ? 1 : 0;
        }

        if(dp[idx][first][second] != -1){
            return dp[idx][first][second];
        }

        int skip = solve(nums,idx + 1, first, second);
        int seq1 = solve(nums,idx+1,gcd(first,nums[idx]),second);
        int seq2 = solve(nums,idx + 1, first,gcd(nums[idx],second));

        long ans = (long) skip + seq1 + seq2;
        return dp[idx][first][second] = (int) (ans % mod);
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}