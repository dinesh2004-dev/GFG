class Solution {
    boolean sameFreq(String s) {
        // code here
        Map<Character,Integer> mpp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int val : mpp.values()){
            
            countMap.put(val,countMap.getOrDefault(val,0)+1);
        }
        
        if(countMap.size() == 1){
            return true;
        }
        else if(countMap.size() == 2){
            List<Integer> freq = new ArrayList<>(countMap.keySet());
            
            int f1 = freq.get(0),f2 = freq.get(1);
            int c1 = countMap.get(f1),c2 = countMap.get(f2);
            if(f1 > f2){
                int tempf1 = f1,tempfC = c1;
                f1 = f2;c1 = c2;
                f2 = tempf1;c2 = tempfC;
                
            }
            if((f1 == 1 && c1 == 1) || (f2 == f1 + 1 && c2 == 1)){
                return true;
            }
        }
        return false;
    }
}