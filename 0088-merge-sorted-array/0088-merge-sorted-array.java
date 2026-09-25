class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int left = 0;
        int right = 0;
        int k = 0;

        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                ans[k++] = nums1[left++];
            } else{
                ans[k++] = nums2[right++];
            }
        }

        while(left < m && m != 0){
            ans[k++] = nums1[left++];
        }

        while(right < n && n != 0){
            ans[k++] = nums2[right++];
        }

        for(int i = 0; i < m + n; i++){
            nums1[i] = ans[i];
        }
    }
}