class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] nge = new int[nums2.length];
        Arrays.fill(nge,-1);

        for(int i = 0; i < nums2.length; i++){
            for(int j = i + 1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    nge[i] = nums2[j];
                    break;
                }
            }
        }

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nge[j];
                }
            }
        }
        return ans;
    }
}