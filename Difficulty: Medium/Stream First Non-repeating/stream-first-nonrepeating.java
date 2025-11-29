class Solution {
    public String firstNonRepeating(String s) {
        // code here
        
        int n = s.length();
        
        int[] firstOccurence = new int[26];
        
        Arrays.fill(firstOccurence,-1);
        
        for(int i = 0; i < s.length(); i++){
            
            if(firstOccurence[s.charAt(i) - 'a'] == -1){
                
                firstOccurence[s.charAt(i) - 'a'] = i;
            } 
        }
        
        StringBuilder res = new StringBuilder();
        int[] freq = new int[26];
        
        for(int i = 0; i < n; i++){
            
            freq[s.charAt(i) - 'a']++;
            
            char choose = '#';
            
            int earliest = n + 1;
            
            for(int j = 0; j < 26; j++){
                
                if(freq[j] == 1 && firstOccurence[j] < earliest){
                    
                    choose = (char) (j + 'a');
                    earliest = firstOccurence[j];
                }
                
            }
            
            res.append(choose);
            
        }
        
        return res.toString();
    }
}