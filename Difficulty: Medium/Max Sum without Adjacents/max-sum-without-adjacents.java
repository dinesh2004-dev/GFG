//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;

       int dp[] = new int[n + 1];

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


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
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
            Solution obj = new Solution();
            int res = obj.findMaxSum(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends