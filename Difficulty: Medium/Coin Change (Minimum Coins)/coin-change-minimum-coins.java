class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;

        int[][] dp = new int[n][sum + 1];

        for(int i = 0; i <= sum; i++){
            if(i % coins[0] == 0){

                dp[0][i] = i / coins[0];
            }
            else{
                dp[0][i] = (int)(1e9);
            }
        }

        for(int i = 1; i < n; i++){

            for(int j = 0; j <= sum; j++){
                int notPick = dp[i - 1][j];

                int pick = (int)(1e9);

                if(j >= coins[i]){
                    pick = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(pick,notPick);
            }
        }

        int ans =dp[n - 1][sum];

        if(ans >= (int)(1e9)){
            return -1;
        }
        return ans;
    }
}