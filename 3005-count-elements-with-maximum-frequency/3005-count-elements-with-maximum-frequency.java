class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int count = 0;

        for(int num : nums){
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num,freq);

            if(freq > maxFreq){
                maxFreq = freq;
                count = 1;
            } else if(freq == maxFreq){
                count++;
            }
        }
        return count * maxFreq;
    }
}