class Solution {
    public boolean canReach(int[] start, int[] target) {
        if(((target[0] - start[0]) + (target[1] - start[1])) % 2 == 0){
            return true;
        }
        return false;
    }
}