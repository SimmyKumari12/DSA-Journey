class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = k; i <= k * 102; i+=k){
            if(!set.contains(i)){
                return i;
            }
        }
        return 1;
    }
}