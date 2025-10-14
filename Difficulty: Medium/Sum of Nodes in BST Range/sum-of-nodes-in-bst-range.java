/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    public int nodeSumUtil(Node root,int l,int r,int[] sum){
        
        if(root == null){
            
            return 0;
        }
        
        if(root.data >= l && root.data <= r){
            
            sum[0] += root.data;
        }
        
        int left = nodeSumUtil(root.left,l,r,sum);
        int right = nodeSumUtil(root.right,l,r,sum);
        
        return left + right;
    }
    public int nodeSum(Node root, int l, int r) {
        // code here
       int[] sum = {0};
       nodeSumUtil(root,l,r,sum);
       return sum[0];
        
    }
}
