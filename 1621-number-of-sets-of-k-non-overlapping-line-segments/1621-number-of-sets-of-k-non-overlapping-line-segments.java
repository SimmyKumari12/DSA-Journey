class Solution {
    int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        long[][] suffix = new long[n + 1][k + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
            suffix[i][0] = n - i;
        }

        for(int j = 1; j <= k; j++){
            for(int i = n - 1; i>=0; i--){
                dp[i][j] = (dp[i + 1][j] + suffix[i + 1][j - 1]) % MOD;
                suffix[i][j] = (dp[i][j] + suffix[i + 1][j]) % MOD;
            }
        }
        return (int)dp[0][k];
    }
}