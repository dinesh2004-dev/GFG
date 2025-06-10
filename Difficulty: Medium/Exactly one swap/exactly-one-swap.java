class Solution {
    int countStrings(String s) {
        // code here
        int n = s.length();
        
        char[] ch = s.toCharArray();
        
        int[] hash = new int[26];
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            
            ans += (i - hash[ch[i] - 'a']);
            hash[ch[i] - 'a']++;
            
        }
        
        for(int i = 0; i < 26; i++){
            
            if(hash[i] > 1){
                ans++;
                break;
            }
        }
        
        return ans;
    }
}