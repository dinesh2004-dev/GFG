class Solution {
    public int countPS(String s) {
        // code here
        int n = s.length();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            count += countPalindromes(s,i,i);
            count += countPalindromes(s,i,i + 1);
        }
        
        return (count - n < 0) ? -1 : count - n;
    }
    public int countPalindromes(String s,int left,int right){
        
        int count = 0;
        
        while(left >= 0 && right < s.length() && 
                s.charAt(left) == s.charAt(right)){
                    
                    count++;
                    left--;
                    right++;
                }
        return count;
    }
}