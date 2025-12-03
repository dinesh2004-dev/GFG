/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int findMaxSum(int[] maxi,Node root){
        
        if(root == null){
            
            return 0;
        }
        
        int left = Math.max(0,findMaxSum(maxi,root.left));
        int right = Math.max(0,findMaxSum(maxi,root.right));
        
        maxi[0] = Math.max(maxi[0],left + right + root.data);
        
        return root.data + Math.max(left,right);
        
        
    }
    int findMaxSum(Node root) {
        // code here
        int[] maxi = {Integer.MIN_VALUE};
        
        findMaxSum(maxi,root);
        
        return maxi[0];
    }
}