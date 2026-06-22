class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n + m];
        int idx = 0;

        for(int i = 0; i < n; i++){
            ans[idx++] = nums1[i];
        }

        for(int i = 0; i < m; i++){
            ans[idx++] = nums2[i];
        }

        Arrays.sort(ans);

        double median = 0;
        int mid = (0 + ans.length)/2;

        if(ans.length % 2 == 0){
            median = (ans[mid - 1] + ans[mid])/2.0;
            return median;
        } else{
            median = ans[mid];
        }
        return median;
    }
}