class SpecialStack {
    Stack<Integer> st;
    int mini;
    public SpecialStack() {
        // Define Stack
        st = new Stack<>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        if(st.isEmpty()){
            
            mini = x;
            st.push(x);
            return;
        }
        
        if(x > mini){
            
            st.push(x);
        }
        else{
            
            st.push(2 * x - mini);
            mini = x;
        }
    }

    public void pop() {
        // Remove the top element from the Stack
        if(st.isEmpty()){
            
            return;
        }
        
        int topVal = st.pop();
        
        if(topVal < mini){
            
            mini = 2 * mini - topVal;
            
        }
    }

    public int peek() {
        // Returns top element of the Stack
        if(st.isEmpty()){
            
            return -1;
        }
        
        int peekVal = st.peek();
        
        if(peekVal < mini){
            
            return mini;
        }
        return peekVal;
    }

    boolean isEmpty() {
        // Check if the stack is empty
        return st.isEmpty();
    }

    public int getMin() {
        // Finds minimum element of Stack
        if(st.isEmpty()){
            
            return -1;
        }
        return mini;
    }
}