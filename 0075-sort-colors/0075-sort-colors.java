class Solution {
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        int idx = 0;
        int n = nums.length;

        for(int num : nums){
            if(num == 0){
                c0++;
            }
            if(num == 1){
                c1++;
            }
            if(num == 2){
                c2++;
            }
        }

        while(idx < n){
            while(c0 > 0){
                nums[idx++] = 0;
                c0--;
            }

            while(c1 > 0){
                nums[idx++] = 1;
                c1--;
            }

            while(c2 > 0){
                nums[idx++] = 2;
                c2--;
            }
        }

    }
}