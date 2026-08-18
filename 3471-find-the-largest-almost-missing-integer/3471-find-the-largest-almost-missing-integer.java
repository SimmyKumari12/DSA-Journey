class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int end = 0; end < n - k + 1; end++){
            int i = end;
            int val = k;
            HashSet<Integer> set = new HashSet<>();

            while(val > 0){
                set.add(nums[i]);
                val--;
                i++;
            }

            for(int num : set){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }

        int ans = -1;
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                ans = Math.max(ans,key);
            }
        }

        return ans;
    }
}