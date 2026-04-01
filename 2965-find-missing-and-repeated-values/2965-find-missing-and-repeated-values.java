class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n];
        int a = 0;
        int b = 0;

        for(int[] row : grid){
            for(int i = 0; i < row.length; i++){
                freq[row[i] - 1]++;
            }
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == 2){
                a = i + 1;
            }
            if(freq[i] == 0){
                b = i + 1;
            }
        }

        return new int[]{a,b};
    }
}