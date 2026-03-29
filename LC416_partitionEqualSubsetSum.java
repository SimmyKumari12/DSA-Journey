public class LC416_partitionEqualSubsetSum{
    public static boolean solution(int[] nums){
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }

        int W = sum/2;

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < W + 1; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = Math.max(nums[i - 1] + dp[i-1][j - nums[i - 1]] , dp[i - 1][j]);
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = Math.abs(sum - sum1);

        if(sum2 - sum1 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {5,11,5,1};
        System.out.print(solution(nums));
    }
}