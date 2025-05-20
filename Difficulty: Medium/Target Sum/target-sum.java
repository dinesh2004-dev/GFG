// User function Template for Java

class Solution {
    private static final int MODULO = (int)1e9+7;
    public static int func(int n,int target,int[] nums){

        // if( i == 0){
        //     if(target == 0 && nums[0] == 0){
        //         return 2;
        //     }
        //     if(target == 0 || nums[0] == target){

        //         return 1;
        //     }

        //     return 0;
        // }

        // int notTaken = func(i - 1,target,nums);
        // int take = 0;
        // if(nums[i] <= target){
        //     take = func(i - 1,target - nums[i],nums);
        // }

        // return take + notTaken;

        int[][] dp = new int[n + 1][target + 1];

        if(nums[0] == 0){

            dp[0][0] = 2;
        }
        else{

            dp[0][0] = 1;
        }

        if(nums[0] != 0 && nums[0] <= target){

            dp[0][nums[0]] = 1;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 0; j <= target; j++){

                int notPick = dp[i - 1][j];
                int pick = 0;
                if(j >= nums[i]){
                    pick = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = (pick + notPick) % MODULO;
            }
        }

        return dp[n][target];

    }
    static int findTargetSumWays(int N, int[] A, int target) {
        // code here
    int sum = Arrays.stream(A).sum();

      if((sum - target) < 0){
             return 0;
      }

      if((sum - target) % 2 == 1){

        return 0;
      }

      int s2 = (sum - target) / 2;

      return func(N - 1,s2,A);
    }
};