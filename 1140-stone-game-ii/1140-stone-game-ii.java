class Solution {
    int n;
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][n][n + 1];

        for(int person = 0; person < 2; person++){
            for(int i = 0; i < n; i++){
                Arrays.fill(dp[person][i],-1);
            }
        }

        return solveForAlice(piles,1,0,1);
    }

    public int solveForAlice(int[] piles, int person, int i, int M){
        if(i >= n){
            return 0;
        }

        if (dp[person][i][M] != -1) {
            return dp[person][i][M];
        }

        int stones = 0;
        int result;
        if(person == 1){
            result = -1;
        } else{
            result = Integer.MAX_VALUE;
        }

        for(int X = 1; X <= Math.min(2 * M,n - i); X++){
            stones += piles[i + X - 1];
            if(person == 1){
                result = Math.max(result,stones + solveForAlice(piles,0, i + X,Math.max(X,M)));
            } else{
                result = Math.min(result,solveForAlice(piles,1, i + X, Math.max(X,M)));
            }
        }
        return dp[person][i][M] = result;
    }
}