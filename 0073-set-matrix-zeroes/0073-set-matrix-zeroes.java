class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //Check for Row
        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        //Check for Col
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        //Check for zeroes excluding firstrow and firstcolumn
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Updating the rows and columns according to firstrow and firstcolumn
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstColZero){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }
}