public class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        int size = 2 * k;

        // Base case vector for length 1
        long[] baseVector = new long[size];
        Arrays.fill(baseVector, 1);

        // Construct the transition matrix T of size (2K) x (2K)
        long[][] T = new long[size][size];
        for (int u = 0; u < k; u++) {
            for (int v = 0; v < k; v++) {
                // From DOWN state at u (index u) to UP state at v (index k + v)
                if (u < v) {
                    T[u][k + v] = 1;
                }
                // From UP state at u (index k + u) to DOWN state at v (index v)
                if (u > v) {
                    T[k + u][v] = 1;
                }
            }
        }

        // Raise the transition matrix to the power of (n - 1)
        long[][] T_pow = matrixPower(T, n - 1);


        long totalArrays = 0;
        for (int j = 0; j < size; j++) {
            long finalStateValue = 0;
            for (int i = 0; i < size; i++) {
                finalStateValue = (finalStateValue + baseVector[i] * T_pow[i][j]) % MOD;
            }
            totalArrays = (totalArrays + finalStateValue) % MOD;
        }

        return (int) totalArrays;
    }

    private long[][] matrixPower(long[][] matrix, int p) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        long[][] base = matrix;
        while (p > 0) {
            if (p % 2 == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            p = p/2;
        }
        return result;
    }

    private long[][] multiplyMatrices(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}