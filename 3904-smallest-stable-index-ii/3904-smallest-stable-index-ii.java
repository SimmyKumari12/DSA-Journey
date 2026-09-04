class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int minArr[] = new int[n]; 
        minArr[n - 1] = nums[n - 1];

        int maxArr[] = new int[n];
        maxArr[0] = nums[0];

        for(int i = 1; i < n; i++){
            maxArr[i] = Math.max(maxArr[i - 1],nums[i]);
        }

        for(int i = n - 2; i>= 0; i--){
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }

        for(int i = 0; i < n; i++){
            int score = maxArr[i] - minArr[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}