class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        // code here
        int row = mat.length;
        int col = mat[0].length;
        
        int diff[][] = new int[row + 1][col + 1];
        for(int[] op : opr){
            int val = op[0];
            int r1 = op[1],c1 = op[2],r2 = op[3],c2 = op[4];
            
            diff[r1][c1] += val;
            if(r2 + 1 < row){
                diff[r2 + 1][c1] -= val;
            }
            if(c2 + 1 < col){
                diff[r1][c2 + 1] -= val;
            }
            if(r2 + 1 < row && c2 + 1 < col){
                diff[r2 + 1][c2 + 1] += val;
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                diff[i][j] += diff[i][j - 1]; 
            }
        }
        
        for(int j = 0; j < col; j++){
            for(int i = 1; i < row; i++){
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            res.add(new ArrayList<>());
            for(int j = 0; j < col; j++){
                res.get(i).add(mat[i][j] + diff[i][j]);
            }
        }
        return res;
    }
}