class Solution {
    static int solve(int[] arr,int i,int j,int[][] dp){
        
        if(i == j){
            
            return 0;
        }
        
        if(dp[i][j] != -1){
            
            return dp[i][j];
        }
        
        int minSteps = (int) 1e9 + 7;
        
        for(int k = i; k <= j - 1; k++){
            
            int steps = arr[i - 1] * arr[k] * arr[j] + solve(arr,i,k,dp) + solve(arr,k + 1,j,dp);
            
            minSteps = Math.min(minSteps,steps);
        }
        
        return dp[i][j] = minSteps;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        
        int[][] dp = new int[arr.length][arr.length];
        
        for(int[] d : dp){
            
            Arrays.fill(d,-1);
        }
        
        return solve(arr,1,arr.length - 1,dp);
    }
}