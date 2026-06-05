class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int m = n / 2;
        int[] ans = new int[n];
        int idx = 0;

        int[] pos = new int[m];
        int[] neg = new int[m];

        int i = 0, j = 0;

        for(int num : nums){
            if(num > 0){
                pos[i++] = num;
            } else{
                neg[j++] = num;
            }
        }

        int x = 0, y = 0;

        while(idx < n && x < m && y < m){
            ans[idx++] = pos[x++];
            ans[idx++] = neg[y++];
        }

        return ans;
    }
}