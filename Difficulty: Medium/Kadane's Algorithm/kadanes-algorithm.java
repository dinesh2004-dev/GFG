class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        
        int n = arr.length;
        
        int sum = 0;
        
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            
            if(sum < 0){
                
                sum = 0;
            }
            
            sum = sum + arr[i];
            
            maxSum = Math.max(maxSum,sum);
        }
        
        return maxSum;
    }
}
