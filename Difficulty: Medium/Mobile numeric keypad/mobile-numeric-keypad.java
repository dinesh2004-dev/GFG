class Solution {
    public int findSequence(int i,int j,int n,int[][][] dp){
       if (i < 0 || i >= 4 || j < 0 || j >= 3 
            || (i == 3 && (j == 0 || j == 2))) {
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n][i][j] != -1){
            return dp[n][i][j];
        }
        
        int[][] directions = new int[][]{{0,0},{1,0},{-1,0},{0,1},
                                {0,-1}};
        int ans = 0;
        
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            
            ans += findSequence(x,y,n - 1,dp);
        }
        return dp[n][i][j] = ans;
    }
    public int getCount(int n) {
        // code here
        int dp[][][] = new int[n + 1][4][3];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                ans += findSequence(i,j,n,dp);
            }
        }
        return ans;
    }
}