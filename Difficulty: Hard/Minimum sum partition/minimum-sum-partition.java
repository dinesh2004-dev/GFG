//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

// User function Template for Java

class Solution {
     public boolean[][] func(int n,int target,int[] arr){
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i < n; i++){

            dp[i][0] = true;
        }

        if(arr[0] <= target){

            dp[0][arr[0]] = true;
        }

        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= target; j++){

                boolean notTaken = dp[i - 1][j];

                boolean take = false; 

                if(arr[i] <= j){

                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = notTaken || take;
            }
        }

        return dp;
    }

    public int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();

        int mini = Integer.MAX_VALUE;
        
        boolean[][] dp = func(n - 1,sum,arr);

        for(int i = 0; i <= sum; i++){

            if(dp[n - 1][i]){

                int diff = Math.abs(i - (sum - i));

                mini = Math.min(mini,diff);
            }
        }

        return mini;
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends