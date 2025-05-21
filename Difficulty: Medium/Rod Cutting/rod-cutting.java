class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int dp[][] = new int[n][n + 1];

        for(int i = 0;i <= n;i++){
            dp[0][i] = price[0] * i;
        }

        for(int i = 1; i < n; i++){

            for(int j = 0; j <= n; j++){
                int notPick = dp[i - 1][j];

                int rodLength = i + 1;

                int pick = Integer.MIN_VALUE;

                if(rodLength <= j){

                    pick = price[i] + dp[i][j - rodLength];
                }

                dp[i][j] = Math.max(pick,notPick);
            }
        }

        return dp[n - 1][n];
    }
}