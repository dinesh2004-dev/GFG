class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        
        int sum = 0;
        int n = arr.length;
        
        if(n == 1){
            
            return arr[0];
        }
        
        int maxSum = 0;
        int countNeg = 0;
        
        for(int i = 0; i < n; i++){
            
            if(arr[i] < 0){
                countNeg++;
            }
            
            sum += arr[i];
            
            maxSum = Math.max(sum,maxSum);
            if(sum < 0){
                
                sum = 0;
            }
        }
        
        if(countNeg == n){
            
            maxSum = Arrays.stream(arr).max().getAsInt();
        }
        
        return maxSum;
    }
}
