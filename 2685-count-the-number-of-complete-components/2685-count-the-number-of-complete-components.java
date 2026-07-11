class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];

        for(int i = 0; i < n; i++){
            if(vis[i]){
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            vis[i] = true;
            q.offer(i);

            int edgeCount = 0;
            int vertexCount = 0;

            while(!q.isEmpty()){
                int curr = q.poll();

                vertexCount++;
                edgeCount += graph[curr].size();

                for(int neigh : graph[curr]){
                    if(!vis[neigh]){
                        vis[neigh] = true;
                        q.offer(neigh);
                    }
                }
            }
            int totalEdges = edgeCount / 2;
            int needEdges = vertexCount * (vertexCount - 1)/2;

            if(totalEdges == needEdges){
                count++;
            }
        }
        return count;
    }
}