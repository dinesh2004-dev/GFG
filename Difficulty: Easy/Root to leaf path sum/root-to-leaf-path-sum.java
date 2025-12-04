/*
// A Binary Tree node
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
    /*you are required to complete this function */
    boolean isLeaf(Node node){
        
        return node.left == null && node.right == null;
    }
    public boolean solve(Node root,int target,int sum){
        
        
        
        if(root == null){
            
            return false;
        }
        
         sum = sum + root.data;
        
        
        if(isLeaf(root)){
             return target == sum;
        }
        
        
        return solve(root.left,target,sum) || solve(root.right,target,sum);
    }
    boolean hasPathSum(Node root, int target) {
        // Your code here
        
        return solve(root,target,0);
        
    }
}