class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            
            if(ch == ')'){
                
                char top = st.peek();
                st.pop();
                
                boolean isRedundant = true;
                
                while(top != '('){
                    
                    if(top == '+' || top == '-' || top == '*'
                        || top == '/'){
                            
                            isRedundant = false;
                        }
                        
                    top = st.peek();
                    st.pop();
                }
                
                if(isRedundant){
                    
                    return true;
                }
            }
            else{
                
                st.push(ch);
            }
        }
        
        return false;
    }
}
