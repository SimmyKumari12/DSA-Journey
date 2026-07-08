import java.util.*;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1_000_000_007;

        int n = s.length();

        // Store only non-zero digits and their positions
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                positions.add(i);
            }
        }

        int m = digits.size();

        // powers of 10
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;

        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // prefix numbers
        long[] prefNum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
        }

        // prefix digit sums
        long[] prefSum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            // first non-zero digit >= l
            int left = lowerBound(positions, l);

            // first position > r
            int right = upperBound(positions, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long number = prefNum[right + 1]
                    - (prefNum[left] * pow10[len]) % MOD;

            number %= MOD;

            if (number < 0)
                number += MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }

    // First index with value >= target
    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    // First index with value > target
    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid) > target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}