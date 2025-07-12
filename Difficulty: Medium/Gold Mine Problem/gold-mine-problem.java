class Solution {
    public int mineGold(int[][] mat,int row,int col,int[][] dp){
        if((row >= 0 && row < mat.length) && col == mat[0].length - 1){
            return mat[row][col];
        }
        if((row < 0 || row >= mat.length) || (col < 0 || col >= mat[0].length)){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int upRight = mat[row][col] + mineGold(mat,row - 1,col + 1,dp);
        int right = mat[row][col] + mineGold(mat,row,col+1,dp);
        int downRight = mat[row][col] + mineGold(mat,row + 1,col + 1,dp);
        
        return dp[row][col] = Math.max(upRight,Math.max(right,downRight));
    }
    public int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int maxGold = Integer.MIN_VALUE;
        int dp[][] = new int[mat.length][mat[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        for(int i = 0; i < n; i++){
            maxGold = Math.max(maxGold,mineGold(mat,i,0,dp));
        }
        return maxGold;
    }
}