//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        int profit = 0;

        for(int i = n - 1; i >= 0; i--){

            for(int buy = 0; buy <= 1; buy++){

                for(int cap = 1; cap <= 2; cap++){

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

        return dp[0][0][2];
    }
}
