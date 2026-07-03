import java.util.*;

class Solution {
    // Adjacency list representation using an inner class
    class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        boolean hasEdges = false;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            
            // Optimization: Skip paths running into offline nodes immediately
            if (!online[u] || !online[v]) continue;
            
            graph.get(u).add(new Edge(v, cost));
            low = Math.min(low, cost);
            high = Math.max(high, cost);
            hasEdges = true;
        }

        if (!hasEdges) return -1;

        int ans = -1;

        // Binary Search for the largest minimum edge-cost
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(graph, online, k, mid, n)) {
                ans = mid;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(List<List<Edge>> graph, boolean[] online, long k, int minWeight, int n) {
        // Priority Queue stores array format: long[]{accumulated_cost, node_id}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // Track optimal distances using long to prevent integer overflow
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE);

        if (!online[0]) return false;

        pq.offer(new long[]{0L, 0L});
        minCost[0] = 0L;

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long cost = current[0];
            int u = (int) current[1];

            if (cost > minCost[u]) continue;
            if (u == n - 1) return cost <= k;

            for (Edge edge : graph.get(u)) {
                if (edge.cost < minWeight) continue; 

                long nextCost = cost + edge.cost;
                if (nextCost < minCost[edge.to] && nextCost <= k) {
                    minCost[edge.to] = nextCost;
                    pq.offer(new long[]{nextCost, (long) edge.to});
                }
            }
        }

        return minCost[n - 1] <= k;
    }
}
