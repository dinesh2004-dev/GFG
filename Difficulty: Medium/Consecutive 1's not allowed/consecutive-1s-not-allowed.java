// User function Template for Java

class Solution {
    public int solve(int i,int n){
        if(i >= n){
            return 1;
        }
        int notPick = solve(i + 1,n);
        int pick = solve(i + 2,n);
        return pick + notPick;
    }
    int countStrings(int n) {
        // code here
        int[] dp = new int[n + 2];
        dp[n + 1] = 1;
        for(int i = dp.length - 2; i >= 0; i--){
            int notPick = dp[i + 1];
            int pick = (i + 2 < dp.length) ? dp[i + 2] : 0;
            dp[i] = pick + notPick;
        }
        return dp[0];
    }
}