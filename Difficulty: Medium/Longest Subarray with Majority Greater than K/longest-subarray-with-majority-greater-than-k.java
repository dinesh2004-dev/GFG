class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        Map<Integer,Integer> mpp = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i] > k){
                prefixSum++;
            }
            else{
                prefixSum--;
            }
            
            if(prefixSum > 0){
                maxLen = i + 1;
            }
            else{
                if(mpp.containsKey(prefixSum - 1)){
                    maxLen = Math.max(maxLen,i - mpp.get(prefixSum - 1));
                }
            }
            if(!mpp.containsKey(prefixSum)){
                mpp.put(prefixSum,i);
            }
        }
        return maxLen;
    }
}