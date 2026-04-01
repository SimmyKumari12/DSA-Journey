class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[m + n];
        int idx = 0;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                help[idx++] = nums1[i++];
            } else{
                help[idx++] = nums2[j++];
            }
        }

        while(i < m){
            help[idx++] = nums1[i++];
        }

        while(j < n){
            help[idx++] = nums2[j++];
        }

        int k = 0;

        for(int id = 0; id < help.length; id++){
            nums1[k++] = help[id];
        }
        
    }
}