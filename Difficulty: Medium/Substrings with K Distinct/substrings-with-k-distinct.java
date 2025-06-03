// User function Template for Java

class Solution {
    public int countAtmostK(String s,int k){
        int n = s.length();
        
        int[] hash = new int[26];
        
        int distinct = 0,cnt = 0;
        
        int i = 0,j = 0;
        
        while(i < n){
            
            int charLen = s.charAt(i) - 'a';
            
            if(hash[charLen] == 0){
                
                distinct++;
            }
            hash[charLen]++;
            
            while(distinct > k){
                int leftIdx = s.charAt(j) - 'a';
                
                hash[leftIdx]--;
                
                if(hash[leftIdx] == 0){
                    
                    distinct--;
                }
                j++;
            }
            
            cnt += i - j + 1;
            
            i++;
        }
        return cnt;
    }
    int countSubstr(String s, int k) {
        // your code here
        return countAtmostK(s,k) - countAtmostK(s,k-1);
    }
}