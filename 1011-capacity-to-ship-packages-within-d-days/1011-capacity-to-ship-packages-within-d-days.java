class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int sum = 0;
        for(int wt : weights){
            left = Math.max(left,wt);
            sum += wt;
        }
        int right = sum;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(isPossible(weights,mid,days)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] weights, int mid, int k){
        int daysCount = 1;
        int total = 0;

        for(int i = 0; i < weights.length; i++){
            if(weights[i] + total <= mid){
                total += weights[i];
            } else{
                daysCount++;
                total = weights[i];
                if(daysCount > k){
                    return false;
                }
            }
        }
        return true;
    }
}