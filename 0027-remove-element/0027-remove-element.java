class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int count = 0;

        while(left <= right){
            if(nums[right] == val){
                right--;
                count++;
            } else if(nums[left] == val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                count++;
            } else{
                left++;
            }
        }

        return n - count;
    }
}