class Solution {
    // Helper function to add two numbers represented as strings
    public String addString(String s1, String s2) {
        int i = s1.length() - 1;  // pointer for s1
        int j = s2.length() - 1;  // pointer for s2
        int c = 0;                // carry
        StringBuilder result = new StringBuilder();  // to store result
        
        // Loop till both strings and carry are processed
        while (i >= 0 || j >= 0 || c > 0) {
            int sum = c;  // initialize with carry
            if (i >= 0) {
                sum += (s1.charAt(i) - '0');  // add digit from s1 if exists
            }
            if (j >= 0) {
                sum += (s2.charAt(j) - '0');  // add digit from s2 if exists
            }
            result.append((char)(sum % 10 + '0')); // add current digit
            c = sum / 10;                          // update carry
            i--; j--;                              // move pointers
        }
        
        // Remove leading zeros from the end (which will be at the beginning after reverse)
        while (result.length() > 0 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        
        // Handle case where result is empty (all zeros)
        if (result.length() == 0) {
            return "0";
        }
        
        // Reverse the result to get final number
        return result.reverse().toString();
    }
    
    public String minSum(int[] arr) {
        Arrays.sort(arr);  // sort digits in ascending order
        StringBuilder s1 = new StringBuilder();  // to build first number
        StringBuilder s2 = new StringBuilder();  // to build second number
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                s1.append((char)(arr[i] + '0'));  // alternate digits go to s1
            } else {
                s2.append((char)(arr[i] + '0'));  // rest go to s2
            }
        }
        
        return addString(s1.toString(), s2.toString());  // return their sum
    }
}