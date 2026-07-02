class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if(startHealth <= 0){
            return false;
        }

        int[][] best = new int[n][m];
        for(int[] row : best){
            Arrays.fill(row,-1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,startHealth});
        best[0][0] = startHealth;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(r == n - 1 && c == m - 1){
                    return true;
                }

                if(nr < 0 || nc < 0 || nr >= n || nc >= m){
                    continue;
                }

                int newHealth = h - grid.get(nr).get(nc);

                if(newHealth <= 0){
                    continue;
                }

                if(newHealth > best[nr][nc]){
                    best[nr][nc] = newHealth;
                    q.offer(new int[]{nr,nc,newHealth});
                }
            }
        }
        return false;
    }
}