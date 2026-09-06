class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> arr = new ArrayList<>();

            while(n > 0){
                TreeNode curr = q.peek();
                q.poll();

                arr.add(curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
                n--;
            }
            res.add(arr);
        }
        

        List<List<Integer>> rev = new ArrayList<>();
        for(int i = res.size() - 1; i >= 0; i--){
            List<Integer> tmp = res.get(i);
            rev.add(tmp);
        }

        return rev;
    }
}