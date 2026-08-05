class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //Part1 : Build an Arraylist
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] in : invocations){
            adj.get(in[0]).add(in[1]);
        }

        //Part 2 : Do Dfs on the k node
        boolean[] sus = new boolean[n];
        dfs(k,sus,adj);

        //Part 3 : Check for impossible removal
        boolean impossible = false;
        for(int[] in : invocations){
            int src = in[0];
            int dest = in[1];

            if(!sus[src] && sus[dest]){
                impossible = true;
            }
        }

        if(impossible){
            for(int i = 0; i < n; i++){
                ans.add(i);
            }
        } else{
            for(int i = 0; i < n; i++){
                if(!sus[i]){
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    public void dfs(int node, boolean[] sus, ArrayList<ArrayList<Integer>> adj){
        sus[node] = true;

        for(int neigh : adj.get(node)){
            if(!sus[neigh]){
                dfs(neigh,sus,adj);
            }
        }
    }
}