class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        //Find break point
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        //Find the most closest greater element with less difference
        if(idx != -1){
            int j = n - 1;
            while(nums[j] <= nums[idx]){
                j--;
            }
            //swap the element with most closest greater element 
            swap(nums,idx,j);
        }

        
        //now reverse the remaning array
        reverse(nums,idx + 1, n - 1);             
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }
}