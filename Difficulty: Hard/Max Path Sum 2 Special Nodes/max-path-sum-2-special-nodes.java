/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    public int findMaxPathSum(Node root,int[] maxi){
        
        if(root == null){
            
            return 0;
        }
        
        int left = findMaxPathSum(root.left,maxi);
        int right = findMaxPathSum(root.right,maxi);
        
        if(root.left != null && root.right != null){
            
            int maxVal = root.data + left + right;
            
            maxi[0] = Math.max(maxi[0],maxVal);
            
            return root.data + Math.max(left,right);
        }
        
        return root.data + ((root.left == null) ? right : left);
    }
    int maxPathSum(Node root) {
        // code here
        int[] maxi = {Integer.MIN_VALUE};
        
        int val = findMaxPathSum(root,maxi);
        
        if(maxi[0] == Integer.MIN_VALUE){
            
            return val;
        }
        
        return maxi[0];
    }
}