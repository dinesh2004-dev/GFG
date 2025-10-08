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
    public Node constructTreeUtil(int[] pre,int[] post,int[] preIndex,int l,int h,int size){
        
        if(preIndex[0] >= size || l > h){
            
            return null;
        }
        
        Node root = new Node(pre[preIndex[0]]);
        preIndex[0]++;
        
        if(l == h){
            
            return root;
        }
        
        int i;
        
        for(i = l; i <= h; i++){
            
            if(pre[preIndex[0]] == post[i]){
                
                break;
            }
        }
        
        if(i <= h){
            
            root.left = constructTreeUtil(pre,post,preIndex,l,i,size);
             root.right = constructTreeUtil(pre,post,preIndex,i + 1,h - 1,size);
        }
        return root;
    }
    public Node constructTree(int[] pre, int[] post) {
        // code here
        int[] preIndex = {0};
        
        int size = pre.length;
        
        return constructTreeUtil(pre,post,preIndex,0,size - 1,size);
    }
}