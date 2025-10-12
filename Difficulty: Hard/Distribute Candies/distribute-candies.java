/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int dfs(Node root,int[] res){
        
        if(root == null){
            
            return 0;
        }
        
        int left = dfs(root.left,res);
        int right = dfs(root.right,res);
        
        res[0] += Math.abs(left) + Math.abs(right);
        
        return root.data + left + right - 1;
    }
    public int distCandy(Node root) {
        // code here
        
        int res[] = {0};
        
        dfs(root,res);
        
        return res[0];
        
    }
}