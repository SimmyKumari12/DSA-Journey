class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;//3
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            sum = sum + nums[i]; //0 + 1 = 1

            if(sum == k){
                count++;
            }

            int target = sum - k; //2 - 1 = 1

            if(map.containsKey(target)){
                count = count + map.get(target);
            } 

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}