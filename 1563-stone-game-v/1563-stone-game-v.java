class Solution {
    int dp[][];
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[501][501];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }

        return solve(0,n-1,prefixSum);
    }

    public int solve(int left, int right, int[] prefixSum){
        if(left >= right){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }

        int score = 0;

        for(int mid = left; mid < right; mid++){
            int leftSum = prefixSum[mid] - ((left > 0)? prefixSum[left - 1] : 0);
            int rightSum = prefixSum[right] - prefixSum[mid];

            if(leftSum < rightSum){
                score = Math.max(score,leftSum + solve(left,mid,prefixSum));
            } else if(rightSum < leftSum){
                score = Math.max(score,rightSum + solve(mid + 1, right, prefixSum));
            } else{
                score = Math.max(score,leftSum + solve(left,mid,prefixSum));
                score = Math.max(score,rightSum + solve(mid + 1, right, prefixSum));
            }
        }
        return dp[left][right] = score;
    }
}