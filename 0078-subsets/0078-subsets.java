class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,new ArrayList<>(),0,res);
        return res;
    }

    void helper(int[] nums, List<Integer> curr, int idx, List<List<Integer>> res){
        int n = nums.length;
        if(idx == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        //Pick the element
        curr.add(nums[idx]);
        helper(nums,curr,idx + 1, res);
        curr.remove(curr.size() - 1);

        //Skip the element
        helper(nums,curr,idx + 1, res);
    }
}