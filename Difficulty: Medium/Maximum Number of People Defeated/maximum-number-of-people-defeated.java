class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        
        int s = (int) Math.sqrt(p);
        
        for(int i = s; i >= 1; i--){
            
            long sum = i * (i + 1L) * (2L * i + 1) / 6;
            
            if(sum <= p){
                
                return i;
            }
        }
        
        return -1;
    }
};