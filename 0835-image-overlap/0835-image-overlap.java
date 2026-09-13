class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(img1[i][j] == 1){
                    list1.add(new int[]{i,j});
                }
                if(img2[i][j] == 1){
                    list2.add(new int[]{i,j});
                }
            }
        }

        int[][] count = new int[2*n][2*n];
        int best = 0;

        for(int[] a : list1){
            for(int[] b : list2){
                int dx = b[0] - a[0] + n;
                int dy = b[1] - a[1] + n;
                best = Math.max(best,++count[dx][dy]);
            }
        }
        return best;
    }
}