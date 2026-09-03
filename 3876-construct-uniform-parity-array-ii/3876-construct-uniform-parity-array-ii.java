class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean odd = false;
        int min = nums1[0];

        for(int num : nums1){
            min = Math.min(num,min);

            if(num % 2 != 0){
                odd = true;
            }
        }

        if(min % 2 != 0){
            return true;
        }

        return !odd;
    }
}