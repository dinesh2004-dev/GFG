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
    public void findNthSmall(Node root,int[] k,int[] nthSmall){
        
        if(root == null){
            
            return;
        }
        findNthSmall(root.left,k,nthSmall);
        
        k[0] -= 1;
        
        if(k[0] == 0){
            
            nthSmall[0] = root.data;
            return;
        }
        
        findNthSmall(root.right,k,nthSmall);
        
    }
    public int findNumberOfNodes(Node root){
        
        if(root == null){
            
            return 0;
        }
        
        int left = findNumberOfNodes(root.left);
        int right = findNumberOfNodes(root.right);
        
        return 1 + left + right;
    }
    public int findMedian(Node root) {
        // Code here
        int numNodes = findNumberOfNodes(root);
        
        int k = 0;
        
        if(numNodes % 2 == 0){
            
            k = numNodes / 2;
        }
        else{
            k = (numNodes + 1) / 2;
        }
        
        int nthSmall[] = {0};
        
        findNthSmall(root,new int[]{k},nthSmall);
        
        return nthSmall[0];
    }
}