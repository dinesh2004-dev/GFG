class Solution {
    
    public void setMatrixZeroes(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int col1 = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    if(j == 0){
                        col1 = 0;
                    }
                    else{
                        mat[0][j] = 0;
                    }
                }
            }
        }
        
         for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // Check for col & row
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
        if(mat[0][0] == 0){
            for(int i = 0; i < n; i++){
                mat[0][i] = 0;
            }
        }
        if(col1 == 0){
            for(int i = 0; i < m; i++){
                mat[i][0] = 0;
            }
        }
    }
}