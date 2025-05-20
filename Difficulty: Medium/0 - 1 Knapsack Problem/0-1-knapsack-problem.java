class Solution {
    static int knapsack(int w, int val[], int wt[]) {
        // code here
        int n = wt.length;
    
        int[][] dp = new int[n][w + 1];

        for (int i = wt[0]; i <= w; i++) {
            dp[0][i] = val[0];
        }

        for(int i = 1;i < n; i++){

            for(int j = 1; j <= w; j++){

                int notPick = dp[i - 1][j];

                int pick = 0;

                if(wt[i] <= j){

                    pick = val[i] + dp[i - 1][j - wt[i]];
                }
                dp[i][j] = Math.max(pick,notPick);
            }
        }

        return dp[n - 1][w];
    }
    }

