class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = -1;
        int idx = 0;
        int min = Integer.MAX_VALUE;

        for(int[] drone : drones){
            int val = Math.abs(target[0] - drone[0]) + Math.abs(target[1] - drone[1]);
            if(val <= drone[2]){  
                if(val >= min){
                    ans = Math.min(ans,idx);
                }else{
                    min = Math.min(min,val);
                    ans = idx;
                }          
            }
            idx++;
        }
        return ans;
    }
}