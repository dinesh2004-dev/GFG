/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    public boolean isSymmetric(Node root) {
        // Code here
        return root == null || isSymmetric(root.left,root.right);
        
    }
    public boolean isSymmetric(Node left,Node right){
        
        if(left == null || right == null){
            
            return left == right;
        }
        if(left.data != right.data){
            
            return false;
        }
        
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}