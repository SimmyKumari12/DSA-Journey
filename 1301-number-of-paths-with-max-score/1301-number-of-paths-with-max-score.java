import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1_000_000_007;
        int N = board.size();
        
        // DP matrices
        int[][] maxScore = new int[N][N];
        int[][] pathCount = new int[N][N];
        
        // Fill maxScore with MIN_VALUE to signify unreachable paths
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxScore[i][j] = Integer.MIN_VALUE;
            }
        }
        
        // Base case at destination 'E' (0,0)
        maxScore[0][0] = 0;
        pathCount[0][0] = 1;
        
        // Traverse row by row, column by column
        for (int i = 0; i < N; i++) {
            String rowStr = board.get(i);
            for (int j = 0; j < N; j++) {
                char cell = rowStr.charAt(j);
                
                // Skip obstacles and the starting destination cell
                if (cell == 'X' || (i == 0 && j == 0)) {
                    continue;
                }
                
                int bestScore = Integer.MIN_VALUE;
                int paths = 0;
                
                // 3 valid incoming directions: Up, Left, and Up-Left
                int[][] directions = {{i - 1, j}, {i, j - 1}, {i - 1, j - 1}};
                
                for (int[] dir : directions) {
                    int r = dir[0];
                    int c = dir[1];
                    
                    // Verify boundaries and if the neighbor is reachable
                    if (r >= 0 && r < N && c >= 0 && c < N && maxScore[r][c] != Integer.MIN_VALUE) {
                        if (maxScore[r][c] > bestScore) {
                            bestScore = maxScore[r][c];
                            paths = pathCount[r][c];
                        } else if (maxScore[r][c] == bestScore) {
                            paths = (paths + pathCount[r][c]) % MOD;
                        }
                    }
                }
                
                // If at least one valid path leads to this cell, calculate totals
                if (bestScore != Integer.MIN_VALUE) {
                    int currentVal = (cell == 'S') ? 0 : (cell - '0');
                    maxScore[i][j] = bestScore + currentVal;
                    pathCount[i][j] = paths;
                }
            }
        }
        
        // Start cell 'S' is located at the bottom-right corner (N-1, N-1)
        int finalScore = maxScore[N - 1][N - 1];
        int finalPaths = pathCount[N - 1][N - 1];
        
        // Return [0, 0] if 'S' is structurally cut off from 'E'
        if (finalScore == Integer.MIN_VALUE) {
            return new int[]{0, 0};
        }
        
        return new int[]{finalScore, finalPaths};
    }
}
