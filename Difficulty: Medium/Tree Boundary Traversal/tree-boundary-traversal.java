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
public void addLeft(Node root,ArrayList<Integer> boundaryNodes){
    
    Node curr = root.left;
    
    while(curr != null){
        
        if(!isLeaf(curr)){
            
            boundaryNodes.add(curr.data);
        }
        if(curr.left != null){
            
            curr = curr.left;
        }
        else{
            
            curr = curr.right;
        }
    }
}
public void addRight(Node root,ArrayList<Integer> boundaryNodes){
    
    ArrayList<Integer> temp = new ArrayList<>();
    
    Node curr = root.right;
    
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
        
        boundaryNodes.add(temp.get(i));
    }
}
public void addBottom(Node root,ArrayList<Integer> boundaryNodes){
    if(root == null){
        return;
    }
    
    if(isLeaf(root)){
        
        boundaryNodes.add(root.data);
        
    }
    
    addBottom(root.left,boundaryNodes);
    addBottom(root.right,boundaryNodes);
}
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> boundaryNodes = new ArrayList<>();
        
        boundaryNodes.add(root.data);
        
        if(isLeaf(root)){
            
            return boundaryNodes;
        }
        
        addLeft(root,boundaryNodes);
        addBottom(root,boundaryNodes);
        addRight(root,boundaryNodes);
       
        
        return boundaryNodes;
    }
}