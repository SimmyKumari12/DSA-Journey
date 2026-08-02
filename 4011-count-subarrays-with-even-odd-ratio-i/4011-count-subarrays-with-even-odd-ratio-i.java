class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int total = 0;

        for(int i = 0; i < n; i++){
            int oddCount = 0;
            int evenCount = 0;
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0){
                    evenCount++;
                } else{
                    oddCount++;
                }
                if(evenCount * b <= oddCount * a){
                    total++;
                }
            }
        }
        return total;
    }
}