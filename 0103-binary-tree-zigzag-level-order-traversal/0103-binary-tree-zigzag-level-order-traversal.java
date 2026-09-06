class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean zigZag = false;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> arr = new ArrayList<>();

            while (n > 0) {
                TreeNode curr = q.poll();

                if (zigZag == false) {
                    arr.add(curr.val);
                } else {
                    arr.add(0, curr.val);
                }

                // Always add children LEFT -> RIGHT
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

                n--;
            }

            res.add(arr);
            zigZag = !zigZag;
        }

        return res;
    }
}