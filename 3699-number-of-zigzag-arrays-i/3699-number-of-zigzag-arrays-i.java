import java.util.Arrays;

class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int k = r - l + 1;

        // up[v] = valid arrays ending at value v where the last step went UP
        // down[v] = valid arrays ending at value v where the last step went DOWN
        int[] up = new int[k];
        int[] down = new int[k];

        // Base Case: Every number on its own is a valid sequence of length 1
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        // Process for lengths from 2 to n
        for (int i = 2; i <= n; i++) {
            int[] nextUp = new int[k];
            int[] nextDown = new int[k];

            // 1. Calculate choices going UP to value 'v'
            // To go up to v, previous value must be strictly less than v (from 'down' state)
            long prefixSumDown = 0;
            for (int v = 0; v < k; v++) {
                nextUp[v] = (int) prefixSumDown;
                prefixSumDown = (prefixSumDown + down[v]) % MOD;
            }

            // 2. Calculate choices going DOWN to value 'v'
            // To go down to v, previous value must be strictly greater than v (from 'up' state)
            long suffixSumUp = 0;
            for (int v = k - 1; v >= 0; v--) {
                nextDown[v] = (int) suffixSumUp;
                suffixSumUp = (suffixSumUp + up[v]) % MOD;
            }

            // Move to the next length layer
            up = nextUp;
            down = nextDown;
        }

        // Sum up all valid endpoints for length n
        long totalArrays = 0;
        for (int v = 0; v < k; v++) {
            totalArrays = (totalArrays + up[v] + down[v]) % MOD;
        }

        return (int) totalArrays;
    }
}