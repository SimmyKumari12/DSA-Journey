class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        int n = nums.length;
        int start = 0;
        int res = 0;

        for(int end = 0; end < n; end++){
            map.put(nums[end],map.getOrDefault(nums[end],0) + 1);

            while(map.size() > 2){
                map.put(nums[start],map.get(nums[start]) - 1);
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                start++;
            }

            res = Math.max(res,end - start + 1);
        }
        return res;
    }
}