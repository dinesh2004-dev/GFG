/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isLeaf(Node root){
        
        return root.left == null && root.right == null;
    }
    public void addLeft(Node root,List<Integer> res){
        
        Node curr = root.left;
        
        while(curr != null){
            
            if(!isLeaf(curr)){
                
                res.add(curr.data);
            }
            if(curr.left != null){
                
                curr = curr.left;
            }
            else{
                
                curr = curr.right;
            }
        }
    }
    
    public void addLeaf(Node root,List<Integer> res){
        
        if(root == null){
            
            return;
        }
        if(isLeaf(root)){
            
            res.add(root.data);
        }
        
        addLeaf(root.left,res);
        addLeaf(root.right,res);
    }
    
    public void addRight(Node root,List<Integer> res){
        
        Node curr = root.right;
        
        List<Integer> temp = new ArrayList<>();
        
        while(curr != null){
            
            if(!isLeaf(curr)){
                
                temp.add(curr.data);
            }
            if(curr.right != null){
                
                curr = curr.right;
            }
            else{
                
                curr = curr.left;
            }
        }
        
        for(int i = temp.size() - 1; i >= 0; i--){
            
            res.add(temp.get(i));
        }
        
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        if(root == null){
            
            return new ArrayList<>();
        }
        
        
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(root.data);
        
        if(isLeaf(root)){
            
            return res;
            
        }
        
        addLeft(root,res);
        addLeaf(root,res);
        addRight(root,res);
        
        return res;
    }
}