class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n + 1][m + 1];

        for(int[] a : dp){
            Arrays.fill(a,-1);
        }

        return helper(s,t,dp,n,m);
    }

    public int helper(String s , String t, int[][] dp, int n, int m){
        if(m == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s.charAt(n - 1) == t.charAt(m - 1)){
            int take = helper(s,t,dp,n - 1, m - 1);
            int skip = helper(s,t,dp,n - 1, m);
            return dp[n][m] = take + skip;
        } else{
            return dp[n][m] = helper(s,t,dp,n - 1, m);
        }
    }
}