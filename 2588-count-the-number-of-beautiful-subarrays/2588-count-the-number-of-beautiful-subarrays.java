import java.util.HashMap;

class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int xor = 0;
        long count = 0;
        
        map.put(0, 1); // base case
        
        for (int num : nums) {
            xor ^= num;
            
            // we need XOR = 0 → so look for same xor
            if (map.containsKey(xor)) {
                count += map.get(xor);
            }
            
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}