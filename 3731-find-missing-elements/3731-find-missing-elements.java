class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }

        ArrayList<Integer> helper = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : nums){
            helper.add(num);
        }

        for(int i = min; i <= max; i++){
            if(!helper.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}