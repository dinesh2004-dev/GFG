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
        
        int line;
        Node node;
        
        public Pair(int line,Node node){
            
            this.line = line;
            this.node = node;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        TreeMap<Integer,Node> mpp = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            
            Pair pair = q.poll();
            
            int line = pair.line;
            Node node = pair.node;
            
            mpp.put(line,node);
            
            if(node.left != null){
                
                q.add(new Pair(line - 1,node.left));
            }
            if(node.right != null){
                
                q.add(new Pair(line + 1,node.right));
            }
        }
        
        for(Map.Entry<Integer,Node> entry : mpp.entrySet()){
            
            ans.add(entry.getValue().data);
        }
        
        return ans;
        
    }
}