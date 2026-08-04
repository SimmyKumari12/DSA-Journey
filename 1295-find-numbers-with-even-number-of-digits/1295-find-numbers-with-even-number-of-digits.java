class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int val = num;
            int digits = 0;
            while(val != 0){
                val = val / 10;
                digits++;
            }
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }
}