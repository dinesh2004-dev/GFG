//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    int minCost(int[] heights) {
        // code here
        int n  = heights.length;

        int[] dp = new int[n];

       for(int i = 0; i < dp.length; i++){
           
           dp[i] = -1;
       }

        dp[0] = 0;

        for(int i = 1; i < n; i++){

            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if(i > 1){
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(jumpOne,jumpTwo);
        }

        return dp[n - 1];
    }
}


//{ Driver Code Starts.

// } Driver Code Ends