class Solution {
    public int missingInteger(int[] nums) {
        int sum = 0;
        int ans = 0;
        int n = nums.length;
        int i = 1;

        sum = nums[0];
        while(i < n && (nums[i] == nums[i - 1] + 1)){
            sum += nums[i];
            i++;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        while(map.containsKey(sum)){
            sum += 1;
        }
        ans = sum;
        return ans;
    }
}