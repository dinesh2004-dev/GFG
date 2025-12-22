// User function Template for Java

class Solution {
    public int findLowerBound(int arr[]){
        
        int low = 0,high = arr.length - 1;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(arr[mid] >= 1){
                
                high = mid - 1;
            }
            else{
                
                low = mid + 1;
            }
        }
        
        return low;
    }
    public int findUpperBound(int arr[]){
        
        int low = 0,high = arr.length - 1;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(arr[mid] > 1){
                
                high = mid - 1;
            }
            else{
                
                low = mid + 1;
            }
        }
        
        return low;
    }
    public int rowWithMax1s(int arr[][]) {
        // code here
        int idx = -1;
        int maxOnes = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            
            int lowerBound = findLowerBound(arr[i]);
            int upperBound = findUpperBound(arr[i]);
            
            int noOfOnes = upperBound - lowerBound;
            
            if(noOfOnes > maxOnes){
                
                maxOnes = noOfOnes;
                idx = i;
            }
        }
        
        return idx;
    }
}