class Solution {
    
    public int findLength(int[] color, int[] radius) {
        // code here
       int n = color.length;
       
       Stack<Integer> st = new Stack<>();
       
       st.push(0);
       
       for(int i = 1; i < n; i++){
          if(!st.isEmpty() && color[i] == color[st.peek()] && radius[i] == radius[st.peek()]){
              
              st.pop();
          }
          else{
              st.push(i);
          }
       }
       return st.size();
    }
}