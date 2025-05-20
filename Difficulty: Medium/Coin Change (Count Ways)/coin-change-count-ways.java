class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int N = coins.length;
         int[][] dp = new int[N][sum + 1];

      for(int i = 0; i <= sum;i++){
            if(i % coins[0] == 0){

                dp[0][i] = 1;
            }
      }

      for(int i = 1; i < N; i++){
        for(int j = 0; j <= sum; j++){

            int notPick = dp[i - 1][j];

            int pick = 0;

            if(j >= coins[i]){

                pick = dp[i][j - coins[i]];
            }

            dp[i][j] = (pick + notPick);
        }
      }

      return dp[N - 1][sum];
    }
}