class Solution {
    public int[] findNGE(int[] arr){
        
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        
        int[] nge = new int[n];
        
        Arrays.fill(nge,n);
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                
                st.pop();
            }
            
            nge[i] = !st.isEmpty() ? st.peek() : n;
            
            st.add(i);
        }
        
        return nge;
    }
    
    public int[] findPGE(int[] arr){
        
        int n = arr.length;
        
         Stack<Integer> st = new Stack<>();
         
        int[] pge = new int[n];
        
        Arrays.fill(pge,-1);
        
        for(int i = 0; i < n; i++){
            
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                
                st.pop();
            }
            
            pge[i] = !st.isEmpty() ? st.peek() : -1;
            
            st.add(i);
        }
        
        return pge;
    }
    public int maxPeople(int[] arr) {
        int n = arr.length;

        // Compute Previous Greater and Next Greater
        int[] prev = findPGE(arr);
        int[] next = findNGE(arr);

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int leftBound = (prev[i] == -1 ? 0 : prev[i] + 1);
            int rightBound = (next[i] == n ? n - 1 : next[i] - 1);

            // Range size gives how many people visible including self
            int count = rightBound - leftBound + 1;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
        
        
        
        
    }
}
