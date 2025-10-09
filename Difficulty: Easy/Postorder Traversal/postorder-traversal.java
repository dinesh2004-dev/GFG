/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public void postOrderUtil(Node root,ArrayList<Integer> res){
        
        if(root == null){
            
            return;
        }
        postOrderUtil(root.left,res);
        postOrderUtil(root.right,res);
        res.add(root.data);
    }
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        postOrderUtil(root,res);
        
        return res;
    }
}