class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        TreeMap<Integer,Integer> mpp = new TreeMap<>();
        
        for(int[] interval : intervals){
            mpp.put(interval[0],mpp.getOrDefault(interval[0],0)+1);
           
           
           
            mpp.put(interval[1] + 1,mpp.getOrDefault(interval[1] + 1,0)-1);
        }
        int maxPowerFul = -1;
        int prefixSum = 0;
        
        for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
            int point = entry.getKey();
            int delta = entry.getValue();
            
            if(delta >= 0){
                prefixSum += delta;
                
                if(prefixSum >= k){
                    maxPowerFul = point;
                }
            }
            else{
                if(prefixSum >= k){
                    maxPowerFul = point - 1;
                }
                prefixSum += delta;
            }
        }
        return maxPowerFul;
    }
}