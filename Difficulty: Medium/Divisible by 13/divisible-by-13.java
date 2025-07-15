class Solution {
    public boolean divby13(String s) {
        // code here
       int n = s.length();
       int rem = 0;
       for(int i = 0; i < n; i++){
           rem = (rem * 10 + (s.charAt(i) - '0')) % 13;
       }
       return rem == 0;
    }
}