import java.util.Arrays;
public class MCM_Memoization {
    public static int mcm_memo(int[] arr, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int cost1 = mcm_memo(arr, i, k, dp);
            int cost2 = mcm_memo(arr,k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans,finalCost);
        }
        return dp[i][j] = ans;
    }
    public static void main(String[] args){
        int[] arr = {3,2,4,2,5};
        int n = arr.length;

        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.print(mcm_memo(arr,1,n - 1, dp));
    }
}
