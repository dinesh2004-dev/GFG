//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;

       int dp[] = new int[n];

       Arrays.fill(dp,-1);

       dp[0] = arr[0];

       for(int i = 1; i < n;i++){

            int pick = arr[i];

            if(i > 1){

                pick += dp[i - 2];
            }
            int notPick = dp[i - 1];

            dp[i] = Math.max(pick,notPick);
       }

       return dp[n - 1];
    }
}