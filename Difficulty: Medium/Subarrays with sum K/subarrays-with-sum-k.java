class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int cnt = 0;
        int n = arr.length;
        int sum = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum = sum + arr[i];
            if(sum == k){
                cnt++;
            }
            if(mpp.containsKey(sum - k)){
                cnt += mpp.get(sum - k);
            }
            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
            
        }
        return cnt;
        
    }
}