class Solution {
    public int[] findNGE(int[] arr){
        
        int n = arr.length;
        int[] nge = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                
                st.pop();
            }
            
            nge[i] = !st.isEmpty() ? st.peek() : n;
            
            st.add(i);
        }
        
        return nge;
    }
     public int[] findNSE(int[] arr){
        
        int n = arr.length;
        int[] nse = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = n - 1; i >= 0; i--){
            
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                
                st.pop();
            }
            
            nse[i] = !st.isEmpty() ? st.peek() : n;
            
            st.add(i);
        }
        
        return nse;
    }
     public int[] findPGE(int[] arr){
        
        int n = arr.length;
        int[] pge = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                
                st.pop();
            }
            
            pge[i] = !st.isEmpty() ? st.peek() : -1;
            
            st.add(i);
        }
        
        return pge;
    }
     public int[] findPSE(int[] arr){
        
        int n = arr.length;
        int[] pse = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                
                st.pop();
            }
            
            pse[i] = !st.isEmpty() ? st.peek() : -1;
            
            st.add(i);
        }
        
        return pse;
    }
    public int subarrayRangesMin(int[] arr){
        
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            int left = i - pse[i];
            int right = nse[i] - i;
            int freq = left * right;
            sum += (arr[i] * freq);
        }
        
        return sum;
    }
    private int subarrayRangesMax(int[] arr){
        
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            int left = i - pge[i];
            int right = nge[i] - i;
            int freq = left * right;
            sum += (arr[i] * freq);
        }
        
        return sum;
    }
    public int subarrayRanges(int[] arr) {
        // code here
        return subarrayRangesMax(arr) - subarrayRangesMin(arr);
    }
}
