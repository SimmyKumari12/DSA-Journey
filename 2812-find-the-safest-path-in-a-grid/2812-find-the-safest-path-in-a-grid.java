class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                dist[i][j] = -1;

                if(grid.get(i).get(j) == 1){
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};

        // Multi-source BFS
        while(!q.isEmpty()){

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int k = 0; k < 4; k++){

                int nr = r + x[k];
                int nc = c + y[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1){

                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        pq.offer(new int[]{dist[0][0],0,0});

        boolean[][] vis = new boolean[n][n];

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int wt = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(vis[r][c]) continue;

            vis[r][c] = true;

            if(r == n-1 && c == n-1){
                return wt;
            }

            for(int k = 0; k < 4; k++){

                int nr = r + x[k];
                int nc = c + y[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]){

                    int nwt = Math.min(wt, dist[nr][nc]);

                    pq.offer(new int[]{nwt,nr,nc});
                }
            }
        }

        return 0;
    }
}