class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(new ArrayList<>(),target,0,candidates,res);
        return res;
    }

    void helper(List<Integer> curr, int target, int idx, int[] candidates, List<List<Integer>> res){

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }


        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i - 1]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }

            curr.add(candidates[i]);
            helper(curr,target - candidates[i],i + 1,candidates,res);
            curr.remove(curr.size() - 1);
        }
    }
}