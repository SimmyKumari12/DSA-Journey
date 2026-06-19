class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < gain.length; i++){
            sum = sum + gain[i];
            maxSum = Math.max(sum,maxSum);
        }
        if(maxSum < 0){
            return 0;
        }
        return maxSum;
    }
}