class Solution {
    public boolean isPalindrome(String s){
        int i = 0,j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
    public void helper(int idx,String s,ArrayList<String> curr,ArrayList<ArrayList<String>> res){
        if(idx == s.length()){
            
            res.add(new ArrayList<>(curr));
            return;
        }
        
        StringBuilder temp = new StringBuilder();
        
        for(int i = idx; i < s.length(); i++){
            
            temp.append(s.charAt(i));
            
            String sub = temp.toString();
            
            if(isPalindrome(sub)){
                
                curr.add(sub);
                
                helper(i + 1,s,curr,res);
                
                curr.remove(curr.size() - 1);
            }
        }
    }
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        helper(0,s,new ArrayList<>(),res);
        return res;
    }
}
