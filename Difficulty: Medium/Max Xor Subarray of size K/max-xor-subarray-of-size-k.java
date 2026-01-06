class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        
        int l = 0,r = 0;
        
        int n = arr.length;
        
        int maxXOR = Integer.MIN_VALUE;
        int xor = 0;
        
        while(r < n){
            
            xor = xor ^ arr[r];
            
            while((r - l + 1) > k){
                
                xor = xor ^ arr[l];
                l++;
            }
            
            if((r - l + 1) == k){
                
                maxXOR = Math.max(maxXOR,xor);
            }
            r++;
        }
        
        return maxXOR;
        
    }
}
