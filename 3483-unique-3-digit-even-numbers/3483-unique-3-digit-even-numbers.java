class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] vis;

    public int totalNumbers(int[] digits) {
        vis = new boolean[digits.length];
        helper(0,0,digits);
        return set.size();
    }

    public void helper(int count, int curr, int[] digits){
        if(count == 3){
            if(curr % 2 == 0){
                set.add(curr);
            }
            return;
        }

        for(int i = 0; i < digits.length; i++){
            if(vis[i]){
                continue;
            }

            if(count == 0 && digits[i] == 0){
                continue;
            }

            vis[i] = true;

            helper(count + 1, curr * 10 + digits[i], digits);

            vis[i] = false;
        }
    }

}