class Solution {
    public boolean solve(String s1,String s2,String s3,int len1,int len2,int len3,boolean[][] dp){
        
        if(len3 == 0){
            
            return true;
        }
        
        boolean op1 = false;
        boolean op2 = false;
        
        if(dp[len1][len2]){
            
            return true;
        }
        
        if(len1 - 1 >= 0 && s1.charAt(len1 - 1) == s3.charAt(len3 - 1)){
            
            op1 = solve(s1,s2,s3,len1 - 1,len2,len3 - 1,dp);
        }
        if(len2 - 1 >= 0 && s2.charAt(len2 - 1) == s3.charAt(len3 - 1)){
            
            op2 = solve(s1,s2,s3,len1,len2 - 1,len3 - 1,dp);
        }
        
        return dp[len1][len2] = op1 || op2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        return solve(s1,s2,s3,s1.length(),s2.length(),s3.length(),dp);
    }
}