class Solution {
    
    public boolean isPalinSent(String s) {
        // code here
        char[] charArr = s.toCharArray();
        int start = 0, end = s.length() - 1;
        
        while(start < end){
            
            
            
            if(charArr[start] == ' ' || !Character.isLetterOrDigit(charArr[start])){
                start++;
                continue;
            }
            if(charArr[end] == ' ' || !Character.isLetterOrDigit(charArr[end])){
                end--;
                continue;
            }
            char char1 = Character.toLowerCase(charArr[start]);
             char char2 = Character.toLowerCase(charArr[end]);
             if(char1 != char2){
                 return false;
             }
             start++;
             end--;
        }
        
        
        return true;
    }
}