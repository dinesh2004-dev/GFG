class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        Map<Integer,Integer> mpp = new HashMap<>();
        
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
        
        Stack<Integer> st = new Stack<>();
        
       ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n,-1));
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && mpp.get(arr[i]) >= mpp.get(st.peek())){
                
                st.pop();
            }
            
            res.set(i, st.isEmpty() ? -1 : st.peek());

            
            st.add(arr[i]);
        }
        
        return res;
    }
}