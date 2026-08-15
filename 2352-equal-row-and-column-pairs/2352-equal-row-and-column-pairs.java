class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans[][] = new int[n][n];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[j][i] = grid[i][j];
            }
        }

        for(int[] row : grid){
            boolean isEqual = false;
            for(int[] val : ans){
                isEqual = Arrays.equals(row,val);
                if(isEqual){
                    count++;
                }
            }     
        }
        return count;
    }
}