// User function Template for Java

class Solution {
    static int inSequence(int a, int b, int c) {
        // code here
        
        int d = b - a;
        
        if(d == 0){
            return 1;
        }
        else if(d < 0){
            
            if(c >= 0){
                
                return 0;
            }
            if(d % c == 0){
                
                return 1;
            }
            
            return 0;
        }
        else{
            
            if(c <= 0){
                
                return 0;
            }
            if(d % c == 0){
                
                return 1;
            }
            
            return 0;
        }
    }
}