class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        int left = 0;
        int right = nums.length - 1;

        int mid = (left + right)/2;

        if(map.get(nums[mid]) > 1){
            return false;
        }

        return true;
    }
}