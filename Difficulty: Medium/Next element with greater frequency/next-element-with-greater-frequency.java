class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        int n = arr.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> st = new Stack<>();
        
        for(int ele : arr){
            mpp.put(ele,mpp.getOrDefault(ele,0)+1);
        }
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && mpp.get(arr[i]) >= mpp.get(st.peek())){
                st.pop();
            }
            res.set(i,(!st.isEmpty()) ? st.peek() : -1);
            st.add(arr[i]);
        }
        return res;
    }
}