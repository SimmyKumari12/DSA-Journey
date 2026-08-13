class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int[] rightSum = new int[n];
        int sum = 0;
        int ans = -1;

        for(int i = n - 1; i >= 0; i--){
            sum += nums[i];
            rightSum[i] = sum;
        }

        sum = 0;
        for(int i = 0; i < n; i++){
            if(i == 0 && rightSum[i + 1] == 0){
                return i;
            } else if(i > 0 && i < n - 1 && sum == rightSum[i + 1]){
                return i;
            } else if (i == n - 1 && sum == 0){
                return i;
            }
            sum += nums[i];
        }
        return ans;
    }
}