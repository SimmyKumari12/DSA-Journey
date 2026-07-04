class Pair{
    int node;
    int weight;
    public Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}


class Solution {
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n + 1];
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            graph.get(u).add(new Pair(v,cost));
            graph.get(v).add(new Pair(u,cost));
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(Pair neigh : graph.get(node)){
                ans = Math.min(ans,neigh.weight);
                if(!vis[neigh.node]){
                    vis[neigh.node] = true;
                    q.offer(neigh.node);
                }
            }
        }
        return ans;
    }
}