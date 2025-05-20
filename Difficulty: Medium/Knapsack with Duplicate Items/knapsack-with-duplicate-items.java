// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = ( i / wt[0]) * val[0];
        }

        for(int i = 1;i < n; i++){

            for(int j = 1; j <= capacity; j++){

                int notPick = dp[i - 1][j];

                int pick = 0;

                if(wt[i] <= j){

                    pick = val[i] + dp[i][j - wt[i]];
                }
                dp[i][j] = Math.max(pick,notPick);
            }
        }

        return dp[n - 1][capacity];
    }
}