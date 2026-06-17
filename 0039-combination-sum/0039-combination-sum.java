class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(),target,0,candidates,res);
        return res;
    }

    void helper(List<Integer> curr, int target, int idx, int[] candidates,List<List<Integer>> res){
        int n = candidates.length;
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }
        if(idx == n){
            return;
        }

        //Either keep or not keep the element
        curr.add(candidates[idx]);
        helper(curr,target - candidates[idx],idx,candidates,res);
        curr.remove(curr.size() - 1);

        //For not keeping the element
        helper(curr,target,idx+1,candidates,res);
    }
}