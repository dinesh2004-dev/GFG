class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        // res.add(0);
        
        int xor = 0;
        
        for(int i = queries.length - 1; i >= 0; i--){
            
            int[] query = queries[i];
            
            if(query[0] == 0){
                
                res.add(query[1] ^ xor);
            }
            else{
                
                xor = xor ^ query[1];
            }
        }
        
       
        
        res.add(xor);
        
        Collections.sort(res);
        
        return res;
    }
}