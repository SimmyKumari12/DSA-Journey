class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1];
        int ans = 0;

        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 0){
                ans = i;
            }
        }
        return ans;
    }
}