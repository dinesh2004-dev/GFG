class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n = arr.length;
        
        Map<Integer,Integer> mpp = new HashMap<>();
        
        int l = 0,r = 0;
        
        int maxLen = 0;
        
        while(r < n){
            
            mpp.put(arr[r],mpp.getOrDefault(arr[r],0)+1);
            
            while(l < r && mpp.size() > 2){
                
                int rem = arr[l];
                mpp.put(rem,mpp.get(rem) - 1);
                
                if(mpp.get(rem) == 0){
                    
                    mpp.remove(rem);
                }
                
                l++;
            }
            
            maxLen = Math.max(maxLen,r - l + 1);
            r++;
        }
        
        return maxLen;
    }
}