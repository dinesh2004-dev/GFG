class Solution {
    public static String minWindow(String s, String p) {
        // code here
        int sLen = s.length();
        int pLen = p.length();
        
        int[] sHash = new int[26];
        int[] pHash = new int[26];
        
        for(int i = 0; i < pLen; i++){
            
            pHash[p.charAt(i) - 'a']++;
        }
        
        int l = 0,r = 0,count = 0;
        int startIdx = -1,minLen = Integer.MAX_VALUE;
        
        while(r < sLen){
            
            char currChar = s.charAt(r);
            
            sHash[currChar - 'a']++;
            
            if(pHash[currChar - 'a'] > 0 && sHash[currChar - 'a'] <= pHash[currChar - 'a']){
                
                count++;
            }
            
            while(count == pLen){
                
                char leftChar = s.charAt(l);
                
                sHash[leftChar - 'a']--;
                
                if(pHash[currChar - 'a'] > 0 &&  sHash[leftChar - 'a'] < pHash[leftChar - 'a']){
                    
                    count--;
                }
                
                int len = r - l + 1;
                
                if(len < minLen){
                    
                    minLen = len;
                    startIdx = l;
                }
                
                l++;
            }
            
            r++;
        }
        
        if(minLen == Integer.MAX_VALUE){
            
            return "";
        }
        
        return s.substring(startIdx,startIdx + minLen);
    }
}