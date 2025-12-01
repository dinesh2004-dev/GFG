class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        
        int n = arr.length;
        
        Map<Integer,Integer> mpp = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        
        int[] res = new int[2];
        
        int k = 0;
        
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(val == 1){
                
                res[k++] = key;
            }
        }
        
        Arrays.sort(res);
        
        return res;
        
    }
}