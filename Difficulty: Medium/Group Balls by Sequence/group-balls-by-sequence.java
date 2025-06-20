class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n % k != 0){
            return false;
        }
        
        HashMap<Integer,Integer> mpp = new HashMap<>();
        
        for(int val : arr){
            mpp.put(val,mpp.getOrDefault(val,0)+1);
        }
        
         List<Integer> uniqueNums = new ArrayList<>(mpp.keySet());
        Collections.sort( uniqueNums);
        
        for(int num :  uniqueNums){
            
            int count = mpp.get(num);
            
            if(count > 0){
                for(int i = 0; i < count; i++){
                    for(int j = 0; j < k; j++){
                        int reqNum = num + j;
                        int reqCount = mpp.getOrDefault(reqNum,0);
                        
                        if(reqCount <= 0){
                            return false;
                        }
                        
                        mpp.put(reqNum,reqCount-1);
                    }
                }
            }
        }
        return true;
    }
}