class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        
        int n = arr.length;
        
        int low = 0,high = n - 1;
        
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == k){
                
                return mid;
            }
            
            if(arr[mid] <= k){
                
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return low;
    }
};