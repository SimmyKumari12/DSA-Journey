class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        mergeSort(nums,low,high);
        return nums;
    }

    public void mergeSort(int[] nums,int low, int high){
        if(low == high) return ;
        int mid = low + (high - low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid + 1, high);
        merge(nums,low,mid,high);
    }

    public void merge(int[] nums, int low , int mid, int high){
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high -low + 1];
        int idx = 0;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[idx++] = nums[left++];
        }

        while(right <= high){
            temp[idx++] = nums[right++];
        }

        //Copying back to nums array
        for(int i = low; i <= high; i++){
            nums[i] = temp[i - low];
        }
    }
}