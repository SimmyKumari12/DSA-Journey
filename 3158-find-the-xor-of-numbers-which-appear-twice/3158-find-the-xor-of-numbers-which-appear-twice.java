class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int n = nums.length;
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((nums[i] ^ nums[j]) == 0){
                    list.add(nums[i]);
                }
            }
        }

        for(int num : list){
            ans = ans ^ num;
        }

        return ans;
    }
}