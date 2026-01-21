class Solution {
    public int[] findPGE(int[] arr){
        
        int n = arr.length;
        
       int[] pge = new int[n];
       Arrays.fill(pge,-1);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                
                st.pop();
            }
            
            pge[i] = (!st.isEmpty()) ? st.peek() : -1;
        
            st.add(i);
        }
        
        return pge;
       
    }
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        
        int[] pge = findPGE(arr);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < pge.length; i++){
            
            res.add(i - pge[i]);
        }
        
        return res;
    }
}