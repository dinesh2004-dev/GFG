class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        Map<Integer,Integer> mpp = new HashMap<>();
        
        int n = arr.length;
        
        int res = 0;
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            
            if(arr[i] > k){
                
                cnt++;
            }
            else{
                
                cnt--;
            }
            
            if(cnt > 0){
                
                res = i + 1;
            }
            else{
                
                if(mpp.containsKey(cnt - 1)){
                    
                    res = Math.max(res,i - mpp.get(cnt - 1));
                }
            }
            
            if(!mpp.containsKey(cnt)){
                
                mpp.put(cnt,i);
            }
        }
        
        return res;
    }
}