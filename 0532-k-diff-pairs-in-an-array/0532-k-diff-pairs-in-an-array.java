class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> pair = new HashMap<>();
        int count = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        if(k == 0){
            for(int num : nums){
                if(map.get(num)>= 2 && !pair.containsKey(num)){
                    pair.put(num,num);
                    count++;
                }
            }
        } else{
            for(int num : nums){
                int val = num + k;
                if(map.containsKey(val) && !pair.containsKey(num)){
                    pair.put(num,val);
                    count++;
                }
            }
        }
        return count;
    }
}