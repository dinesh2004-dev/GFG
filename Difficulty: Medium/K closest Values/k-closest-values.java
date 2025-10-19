/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    class Pair{
        
        int nodeVal;
        int diff;
        public Pair(int nodeVal,int diff){
            
            this.nodeVal = nodeVal;
            this.diff = diff;
        }
    }
    public void findKClosest(Node root,int target,int k,PriorityQueue<Pair> pq){
        
        if(root == null){
            
            return;
        }
        
        findKClosest(root.left,target,k,pq);
        
        pq.add(new Pair(root.data,Math.abs(root.data - target)));
        if(pq.size() > k){
            
            pq.poll();
        }
        
        findKClosest(root.right,target,k,pq);
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> {
            
            if(x.diff == y.diff){
                
               return y.nodeVal - x.nodeVal;
            }
            
            return y.diff - x.diff;
            
        });
        findKClosest(root,target,k,pq);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            
            ans.add(pq.poll().nodeVal);
        }
        
        return ans;
    }
}