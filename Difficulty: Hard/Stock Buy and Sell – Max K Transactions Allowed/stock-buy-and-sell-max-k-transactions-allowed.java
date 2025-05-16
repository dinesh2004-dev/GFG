//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxProfit(int prices[], int k) {
        // code here
        int n = prices.length;
         int[][][] dp = new int[n + 1][2][k + 1];

        int profit = 0;

        for(int i = n - 1; i >= 0; i--){

            for(int buy = 0; buy <= 1; buy++){

                for(int cap = 1; cap <= k; cap++){

                    if(buy == 0){

                        profit = Math.max(0 + dp[i + 1][0][cap],(-1) * prices[i] + dp[i + 1][1][cap]);
                    }
                    else{
                        profit = Math.max(0 + dp[i + 1][1][cap],prices[i] + dp[i + 1][0][cap - 1]);
                    }

                     dp[i][buy][cap] = profit;
                }

               
            }
        }

        return dp[0][0][k];
    }
}