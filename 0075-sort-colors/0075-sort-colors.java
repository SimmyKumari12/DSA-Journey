class Solution {
    public void sortColors(int[] nums) {
        //Keeping 3 pointers to keep track of 0's , 1's and 2's
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        for(int i = 0; i < n; i++){
            if(nums[mid] == 0){//swap with low
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 2){//swap with high
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            } else{
                mid++;
            }
        }
    }
}