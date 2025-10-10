/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        boolean leftToRight = false;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                Node node = q.poll();
                temp.add(node.data);
                
                if(node.left != null){
                    
                    q.add(node.left);
                }
                if(node.right != null){
                    
                    q.add(node.right);
                }
                
            }
            
            Collections.reverse(temp);
            
            if(!leftToRight){
                Collections.reverse(temp);
                
            }
            
            for(int ele : temp){
                
                res.add(ele);
            }
            leftToRight = !leftToRight;
            
        }
        
        return res;
    }
}