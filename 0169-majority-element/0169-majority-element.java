class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
                count++;
            } else if(candidate == num){
                count++;
            } else if(candidate != num){
                count--;
            }
        }
        return candidate;
    }
}