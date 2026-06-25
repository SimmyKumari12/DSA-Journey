class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == target){
                    count++;
                }
                int size = j - i + 1;
                if(count > (size/2)){
                    ans++;
                }
            }
        }
        return ans;
    }
}