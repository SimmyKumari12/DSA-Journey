class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        for(int num : nums){
            left = Math.max(left,num);
            sum += num;
        }
        int right = sum;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(isPossible(nums,mid,k)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int mid, int k){
        int waysCount = 1;
        int total = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] + total <= mid){
                total += nums[i];
            } else{
                waysCount++;
                total = nums[i];
                if(waysCount > k){
                    return false;
                }
            }
        }
        return true;
    }
}