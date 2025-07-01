class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int count = 0;
        
        for(int i = 0;(i + k) <= n; i++){
            
            String str = s.substring(i,i + k);
            
            Set<Character> set = new HashSet<>();
            
            for(char ch : str.toCharArray()){
                set.add(ch);
            }
            
            if(set.size() == k - 1){
                count++;
            }
            
        }
        return count;
    }
}