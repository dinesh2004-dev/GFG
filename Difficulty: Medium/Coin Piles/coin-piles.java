class Solution {
    public int upperBound(int[] arr,int key,int low,int high){
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(arr[mid] <= key){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int minimumCoins(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i < n;i++){
            prefixSum[i] += prefixSum[i - 1] + arr[i];
        }
        
        int ans = Integer.MAX_VALUE,prev = 0;
        
        for(int i = 0; i < n; i++){
            
            if(i > 0 && arr[i] == arr[i - 1]);
            
            if(i > 0){
                prev = prefixSum[i - 1];
            }
            
            int pos = upperBound(arr,arr[i] + k,i,n);
            
            int totalToRemove = prev;
            
            if(pos < n){
                
                totalToRemove += prefixSum[n - 1] - prefixSum[pos - 1] 
                
                - (n - pos) * (arr[i] + k);
            }
            ans = Math.min(ans,totalToRemove);
        }
        return ans;
    }
}
