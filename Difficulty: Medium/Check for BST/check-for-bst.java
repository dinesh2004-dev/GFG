/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean inorder(Node root,int[] prev){
        
        if(root == null){
            
            return true;
        }
        
        if(!inorder(root.left,prev)){
            
            return false;
        }
        
        if(prev[0] >= root.data){
            
            return false;
        } 
        
        prev[0] = root.data;
        
        return inorder(root.right,prev);
    }
    public boolean isBST(Node root) {
        // code here
        int[] prev = new int[]{0};
        
        return inorder(root,prev);
    }
}