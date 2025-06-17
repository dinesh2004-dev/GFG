// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
    
        for(int i = 0; i < n;i++){
            pq.add(arr[i]);
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
