

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        
        int low = 0,high = n - 1;
        
        int res = n + k;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            if(arr[mid] > (k + mid)){
                
                res = k + mid;
                
                
                high = mid - 1;
            }
            else{
               low = mid + 1;
            }
        }
        return res;
    }
}