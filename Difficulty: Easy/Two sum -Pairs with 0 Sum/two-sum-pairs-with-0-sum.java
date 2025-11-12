import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        int n = arr.length;
        
        // The list to store our final answer
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // Step 1: Sort the array. This is the O(n log n) part.
        Arrays.sort(arr);
        
        // Step 2: Initialize two pointers
        int left = 0;
        int right = n - 1;
        
        // Step 3: Loop while pointers haven't crossed
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // Case 1: Found a pair
            if (sum == 0) {
                // Add the pair to our answer
                ans.add(new ArrayList<>(Arrays.asList(arr[left], arr[right])));
                
                // --- Crucial Step: Skip Duplicates ---
                
                // Skip all duplicates of the left element
                int leftValue = arr[left];
                while (left < right && arr[left] == leftValue) {
                    left++;
                }
                
                // Skip all duplicates of the right element
                int rightValue = arr[right];
                while (left < right && arr[right] == rightValue) {
                    right--;
                }
            } 
            // Case 2: Sum is too small, need a larger number
            else if (sum < 0) {
                // Move the left pointer to the right
                left++;
            } 
            // Case 3: Sum is too large, need a smaller number
            else {
                // Move the right pointer to the left
                right--;
            }
        }
        
        // The 'ans' list is already sorted because we built it from a sorted array.
        return ans;
    }
}