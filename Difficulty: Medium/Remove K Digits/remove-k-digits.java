class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            while(!st.isEmpty() && k > 0 && st.peek() > ch){
                
                st.pop();
                k--;
            }
            
            if(!st.isEmpty() || ch != '0'){
                
                st.push(ch);
            }
            
        }
        
        while(!st.isEmpty() && k > 0){
            
            st.pop();
            k--;
        }
        
        if(st.isEmpty()){
            
            return "0";
        }
        StringBuilder res = new StringBuilder();
        
        while(!st.isEmpty()){
            
            res.append(st.pop());
        }
        
        return res.reverse().toString();
    }
}