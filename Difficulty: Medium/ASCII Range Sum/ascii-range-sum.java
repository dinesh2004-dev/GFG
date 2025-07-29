class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int n = s.length();
        int[] prefixSum = new int[n];
        char[] chars = s.toCharArray();
        prefixSum[0] = chars[0];
        
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + chars[i];
        }
        
        Map<Character,ArrayList<Integer>> mpp = new HashMap();
       for(int i = 0; i < n; i++){
            if(mpp.containsKey(chars[i])){
               ArrayList<Integer> val = mpp.get(chars[i]);
               if(val.size() == 2){
                   val.remove(val.size() - 1);
               }
               val.add(i);
               mpp.put(chars[i],val);
            }
            else{
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                mpp.put(chars[i],res);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Character,ArrayList<Integer>> entry : mpp.entrySet()){
            ArrayList<Integer> list = entry.getValue();
           if(list.size() == 2){
               int asciSum = prefixSum[list.get(1) - 1] - prefixSum[list.get(0)];
              if( asciSum != 0){
               res.add(asciSum);
              }
           }
        }
        return res;
        
        
    }
}