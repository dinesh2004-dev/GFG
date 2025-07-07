class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> nge = new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> st = new Stack<>();
        

        for(int i = n * 2 - 1; i >= 0; i--){

            while(!st.isEmpty() && arr[i % n] >= st.peek()){
                st.pop();
            }
            nge.set(i % n,(!st.isEmpty()) ? st.peek() : -1);
            st.add(arr[i % n]);
        }
        return nge; 
    }
}