class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        nQueens(n, res, board, 0);
        return res;
    }

    void nQueens(int n , List<List<String>> res, char[][] board, int row){
        if(row == n){
            res.add(construct(board));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                nQueens(n,res,board,row + 1);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col, int n){
        //Vertical Condition check
        for(int i = 0; i < n; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //Horizontal Condition Check
        for(int j = 0; j < n; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        //Left Diagonal Check
        for(int i = row, j = col; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Right Diagonal Check
        for(int i = row, j = col; i >= 0 && j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    List<String> construct(char[][] board){
        ArrayList<String> list = new ArrayList<>();
        for(char[] row : board){
            list.add(new String(row));
        }
        return list;
    }
}