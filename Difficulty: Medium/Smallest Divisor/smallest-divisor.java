class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int low = 1,high = Arrays.stream(arr).max().getAsInt();
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            int sum = 0;
            
            for(int ele : arr){
                
                sum += (ele + mid - 1) / mid;
            }
            
            if(sum <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}