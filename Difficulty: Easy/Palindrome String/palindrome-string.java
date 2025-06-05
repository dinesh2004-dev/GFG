class Solution {
    boolean isPalindrome(String s) {
        // code here
        for(int i = 0; i < s.length() / 2; i++){
            
            char first = s.charAt(i);
            
            char last = s.charAt(s.length() - 1 - i);
            
            if(first != last){
                return false;
            }
        }
        return true;
    }
}