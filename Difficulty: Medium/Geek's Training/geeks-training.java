// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int[][] dp = new int[arr.length + 1][4];
        for(int row = arr.length - 1; row  >= 0; row--){
            for(int prev = -1; prev <= 2; prev++){
                int maxi = 0;
                for(int col = 0; col < 3; col++){
                    if(prev != col){
                        int activity = arr[row][col] + dp[row + 1][col + 1];
                        maxi = Math.max(maxi,activity);
                    }
                }
                dp[row][prev + 1] = maxi;
            }
        }
        return dp[0][0];
    }
}