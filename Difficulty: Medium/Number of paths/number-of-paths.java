//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int m = Integer.parseInt(read.readLine());
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int numberOfPaths(int m, int n) {
        // Code Here
        int[][] dp = new int[m][n];

       

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if( i== 0 && j== 0){

                    dp[i][j] = 1;

                    continue;
                }

                int up = 0;
                int left = 0;
                if(i > 0){
                    up = dp[i - 1][j];
                }
                if(j > 0){
                 left = dp[i][j - 1];
                }

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }
}