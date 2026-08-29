class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length; //[1,7,6,18,2,1]
        int[] sorted = nums.clone();
        Arrays.sort(sorted); //[1,1,2,6,7,18] , limit = 3

        HashMap<Integer, Integer> group = new HashMap<>();
        HashMap<Integer, Integer> jIdx = new HashMap<>();

        int[] ans = new int[n];
        int grp = 0;
        group.put(sorted[0], grp); //[1,0]
        jIdx.put(grp, 0); //[0,0]

        for (int i = 1; i < n; i++) {
            if (sorted[i] - sorted[i - 1] > limit){  
                grp++; //grp -> 1 , grp -> 2
                jIdx.put(grp, i); //(1,3) ,(2,5)
            }
            group.put(sorted[i], grp); //[1,0],[2,0],[6,1],[7,1],[18,2]
        }

        int i = 0;
        while (i < n) {
            int currgrp = group.get(nums[i]); //0,1
            int j = jIdx.get(currgrp); //0,3

            ans[i] = sorted[j];//ans[0] = sorted[0] => 1 , ans[1] = 6
            jIdx.put(currgrp, j + 1); //(0,1)
            i++; //1
        }
        return ans;
    }
}