import java.util.Arrays;

public class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Step 1: Create an array of indices and sort it based on their values in nums
        Integer[] sortedIdx = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedIdx[i] = i;
        }
        Arrays.sort(sortedIdx, (a, b) -> Integer.compare(nums[a], nums[b]));

        // Calculate maximum power of 2 needed for binary lifting
        int maxPower = (int) (Math.log(n) / Math.log(2)) + 1;
        int[][] f = new int[n][maxPower];

        // Step 2: Calculate the furthest index reachable in 1 jump using a sliding window
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r < n && nums[sortedIdx[r]] - nums[sortedIdx[l]] <= maxDiff) {
                r++;
            }
            // FIX: Store the single-jump (2^0) state into the 0-th index of the table
            f[l][0] = r - 1;
        }

        // Step 3: Populate the binary lifting table
        for (int k = 1; k < maxPower; k++) {
            for (int i = 0; i < n; i++) {
                f[i][k] = f[f[i][k - 1]][k - 1];
            }
        }

        // Map the original node ID to its sorted index position for O(1) query lookups
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[sortedIdx[i]] = i;
        }

        // Step 4: Answer each path query
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u == v) {
                ans[i] = 0;
                continue;
            }
            if (u > v) { // Swap to ensure we always move from smaller to larger values
                int temp = u;
                u = v;
                v = temp;
            }

            int distance = 0;
            // Lift u towards v using descending powers of 2
            for (int k = maxPower - 1; k >= 0; k--) {
                if (f[u][k] < v) {
                    distance |= (1 << k);
                    u = f[u][k];
                }
            }

            // FIX: Access the 0-th column state to check if 1 final jump can touch or pass v
            if (f[u][0] >= v) {
                ans[i] = distance + 1;
            } else {
                ans[i] = -1; // Target node v is completely unreachable
            }
        }

        return ans;
    }
}


