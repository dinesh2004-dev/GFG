/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    public int kthSmallestUtill(Node root,int k,int[] curr){
        
        if(root == null){
            
            return -1;
        }
        
        int left = kthSmallestUtill(root.left,k,curr);
        
        if(left != -1){
            
            return left;
        }
        
        curr[0]++;
        
        if(curr[0] == k){
            
            return root.data;
        }
        
        int right = kthSmallestUtill(root.right,k,curr);
        
        return right;
    }
    public int kthSmallest(Node root, int k) {
        // code here
        int curr[] = {0};
        return kthSmallestUtill(root,k,curr);
        
    }
}