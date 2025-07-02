class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n = arr.length;
        if (n <= 2) return n;
        
        int left = 0;
        int maxLen = 0;
        int first = -1, firstCount = 0;
        int second = -1, secondCount = 0;
        
        for (int right = 0; right < n; right++) {
            if (arr[right] == first) {
                firstCount++;
            } else if (arr[right] == second) {
                secondCount++;
            } else if (first == -1) {
                first = arr[right];
                firstCount = 1;
            } else if (second == -1) {
                second = arr[right];
                secondCount = 1;
            } else {
                // Third distinct element found - need to shrink window
                while (firstCount > 0 && secondCount > 0) {
                    if (arr[left] == first) {
                        firstCount--;
                    } else if (arr[left] == second) {
                        secondCount--;
                    }
                    left++;
                }
                
                // Replace the eliminated element with the new one
                if (firstCount == 0) {
                    first = arr[right];
                    firstCount = 1;
                } else {
                    second = arr[right];
                    secondCount = 1;
                }
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}