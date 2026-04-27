class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int maxFreq = Integer.MIN_VALUE;

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for(int value : map.values()){
            maxFreq = Math.max(maxFreq,value);
        }

        for(int key : map.keySet()){
            if(map.get(key) == maxFreq){
                ans = ans + maxFreq;
            }
        }
        return ans;
    }
}