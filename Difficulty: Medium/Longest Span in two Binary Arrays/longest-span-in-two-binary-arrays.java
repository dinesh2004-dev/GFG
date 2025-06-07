
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        HashMap<Integer,Integer> mpp = new HashMap<>();
        
        int n = a1.length;
        
        int sum1 = 0,sum2 = 0;
        
        int res = 0;
        
        for(int i = 0; i < n; i++){
            
            sum1 += a1[i];
            sum2 += a2[i];
            
            int currDiff = sum1 - sum2;
            
            if(currDiff == 0){
                
                res = Math.max(res,i + 1);
            }
            else if(mpp.containsKey(currDiff)){
                
                res = Math.max(res,i - mpp.get(currDiff));
            }
            else{
                mpp.put(currDiff,i);
            }
            
        }
        return res;
    }
}