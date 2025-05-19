//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    
    public int func(int n,int[]  arr,int target){
        
        
        // if(i == 0){
            
        //     if(target == 0 && arr[0] == 0){
                
        //         return 2;
        //     }
        //     if(target == 0 || target == arr[0]){
                
        //         return 1;
        //     }
            
        //     return 0;
        // }
        
        // int notPick = func(i - 1,arr,target);
        
        // int pick = 0;
        
        // if(arr[i] <= target){
            
        //     pick = func(i - 1,arr,target - arr[i]);
        // }
        
        // return (pick + notPick);
        
        int dp[][] = new int[n + 1][target + 1];

    if(arr[0] == 0){

        dp[0][0] = 2;
    }
    else{
        dp[0][0] = 1;
    }
    
    if(arr[0] != 0 && arr[0] <= target){

        dp[0][arr[0]] = 1;
    }

    for(int i = 1; i <= n; i++){
        for(int j = 0; j <= target; j++){

            int notPick = dp[i - 1][j];

            int pick = 0;

            if(arr[i] <= j){

                pick = dp[i - 1][j - arr[i]];
            }

            dp[i][j] = (pick + notPick);
        }

    }
     return dp[n][target];
    }
    int countPartitions(int[] arr, int d) {
        // code here
        int sum = Arrays.stream(arr).sum();
        
        if(sum - d < 0){
            return 0;
        }
        if((sum - d) % 2 == 1){
            
            return 0;
        }
        
        int s2 = (sum - d)/2;
        
        return func(arr.length - 1,arr,s2);
    }
}
