class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        Map<Integer,Integer> mpp = new HashMap<>();
        
        int n = a1.length;
        
        int sum1 = 0,sum2 = 0;
        
        int maxLen = 0;
        
        for(int i = 0; i < n; i++){
            
            sum1 += a1[i];
            sum2 += a2[i];
            
            int currDiff = sum1 - sum2;
            
            if(currDiff == 0){
                
                maxLen = Math.max(maxLen,i - 0 + 1);
            }
            
            else if(mpp.containsKey(currDiff)){
                
                maxLen = Math.max(maxLen,i - mpp.get(currDiff));
            }
            else{
                
                mpp.put(currDiff,i);
            }
        }
        
        return maxLen;
    }
}