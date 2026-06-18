class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(nums,new ArrayList<>(),res,vis);
        return res;
    }

    void helper(int[] nums, List<Integer> curr, List<List<Integer>> res,boolean[] vis){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!vis[i]){
                curr.add(nums[i]);
                vis[i] = true;
                helper(nums,curr,res,vis);
                //Backtracking step
                curr.remove(curr.size() - 1);
                vis[i] = false;
            }
        }
    }
}