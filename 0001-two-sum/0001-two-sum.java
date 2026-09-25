class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int val = target - nums[i];
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            } else{
                map.put(val,i);
            }
        }
        return new int[]{-1,-1};
    }
}