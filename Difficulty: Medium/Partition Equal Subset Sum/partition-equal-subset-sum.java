//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean func(int n,int[] arr,int k){

    //     if(k == 0){

    //         return true;
    //     }
    //     if(i == 0){

    //         return arr[0] == k;
    //     }

    //     boolean notPick = func(i - 1,arr,k);

    //     boolean pick = false;

    //     if(arr[i] <= k){
    //         pick = func(i - 1,arr,k - arr[i]);
    //     }

    //     return notPick || pick;

        boolean[][] dp = new boolean[n + 1][k + 1];

        for(int i = 0; i <= n; i++){

            dp[i][0] = true;
        }
        if(arr[0] <= k){

            dp[0][arr[0]] = true;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= k;j++){

                boolean notPick = dp[i - 1][j];

                boolean pick = false;

                if(j >= arr[i]){

                    pick = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = pick || notPick;

            }
        }

        return dp[n][k];
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = Arrays.stream(arr).sum();
        
        int n = arr.length;

            if(sum % 2 == 1){
                return false;
            }
            else{

                int k = sum / 2;

                return func(n - 1,arr,k);
            }
    }
}