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
} */

class Solution {
    public static void findGreaterSum(Node root,int[] sum){
        
        if(root == null){
            
            return;
        }
        
        findGreaterSum(root.right,sum);
        
        sum[0] += root.data;
        root.data = sum[0] - root.data;
        
        findGreaterSum(root.left,sum);
    }
    public static void transformTree(Node root) {
        // code here
        int[] sum = {0};
        
        findGreaterSum(root,sum);
    }
}