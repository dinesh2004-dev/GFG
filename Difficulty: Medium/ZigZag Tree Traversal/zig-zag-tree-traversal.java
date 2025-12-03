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
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        ArrayList<Integer> res = new ArrayList<>();
        
        boolean reverse = false;
        
        while(!q.isEmpty()){
            
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            
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
            
            if(reverse){
                
                Collections.reverse(temp);
            }
            
            for(int ele : temp){
                
                res.add(ele);
            }
            
            reverse = !reverse;
        }
        
        return res;
    }
}