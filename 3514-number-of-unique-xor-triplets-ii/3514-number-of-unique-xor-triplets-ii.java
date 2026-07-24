class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int max = 2047;
        boolean[] first = new boolean[max + 1];
        boolean[] second = new boolean[max + 1];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                first[nums[i] ^ nums[j]] = true;
            }
        }

        for(int i = 0; i < max; i++){
            if(!first[i]){
                continue;
            }
            for(int j = 0; j < n; j++){
                second[nums[j] ^ i] = true;
            }
        }

        int cnt = 0;
        for(int i = 0; i <= max; i++){
            if(second[i] == true){
                cnt++;
            }
        }
        return cnt;
    }
}