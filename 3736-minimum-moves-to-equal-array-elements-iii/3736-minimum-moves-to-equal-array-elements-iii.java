class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int moves = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] < max){
                moves += max - nums[i];
            }
        }
        return moves;
    }
}