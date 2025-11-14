class myStack {
    
    int[] stack;
    int top ;

    public myStack(int n) {
        // Define Data Structures
        stack = new int[n];
        top = -1;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == -1;
    }

    public boolean isFull() {
        // check if the stack is full
        
        return top == stack.length - 1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        top++;
        stack[top] = x;
        
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(isEmpty()){
            
            return;
        }
        stack[top] = 0;
        top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()){
            
            return -1;
        }
        return stack[top];
    }
}