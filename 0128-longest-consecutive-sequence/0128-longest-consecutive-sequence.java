class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            //Loop will run only when it is start of the sequence
            if(!set.contains(num - 1)){
                int curr = num;
                len = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    len++;
                }

                maxLen = Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}