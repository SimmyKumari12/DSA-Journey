class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        //1 base case [1,1,1,1,1]
        int maxLen = 1;
        if(map.containsKey(1)){
            int countOnes = map.get(1);
            if(countOnes % 2 == 0){
                maxLen = Math.max(maxLen, countOnes - 1);
            }else{
                maxLen = Math.max(maxLen, countOnes);
            }
        }

        //For base cases which are greater than 1 
        for(int x : map.keySet()){
            if(x == 1) continue;

            int currLen = 0;
            int curr = x;

            while(map.containsKey(curr) && map.get(curr) >= 2){
                currLen += 2;
                curr = curr * curr;
            }

            if(map.containsKey(curr) && map.get(curr) >= 1){
                currLen += 1;
            } else{
                currLen -= 1;
            }

            maxLen = Math.max(maxLen,currLen);
        }
        return maxLen;
    }
}