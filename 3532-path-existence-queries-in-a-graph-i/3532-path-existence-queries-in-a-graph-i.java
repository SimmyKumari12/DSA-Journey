class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] groups = new int[n];
        int groupId = 0;
        groups[0] = groupId;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                groupId++; 
            }
            groups[i] = groupId;
        }
        
        // Step 2: Answer each query instantly
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int startNode = queries[i][0];
            int endNode = queries[i][1];
            
            // If they are in the same group, a valid path exists
            result[i] = (groups[startNode] == groups[endNode]);
        }
        
        return result;
    }
}
