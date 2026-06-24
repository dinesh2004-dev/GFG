class Solution {
    private boolean solve(int r,int c,int[][] mat,int[][] temp,int[][] dp){
        
        if(r >= mat.length || c >= mat[0].length){
            
            return false;
        }
        
        if(r == mat.length - 1 && c == mat[0].length - 1){
            
            temp[r][c] = 1;
            return true;
        }
        
        if(mat[r][c] == 0){
            
            return false;
        }
        
        if (dp[r][c] != -1)
            return dp[r][c] == 1;
            
        temp[r][c] = 1;
        
        for(int i = 1; i <= mat[r][c]; i++){
            
            if(c + i < mat[0].length && solve(r,c + i,mat,temp,dp)){
                
                dp[r][c] = 1;
                
                return true;
            }
            
            if(r + i < mat.length && solve(r + i,c,mat,temp,dp)){
                
                dp[r][c] = 1;
                
                return true;
            }
            
            
        }
        
        temp[r][c] = 0;
        dp[r][c] = 0;
        
        return false;
    }
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        // code here
        
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] temp = new int[m][n];
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        boolean found = solve(0, 0, mat, temp, dp);

        if (!found) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(Arrays.asList(-1)));
            return res;
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            
            res.add(new ArrayList<>());
            
            for(int j = 0; j < n; j++){
                
                res.get(i).add(temp[i][j]);
            }
        }
        
        return res;
        
    }
}