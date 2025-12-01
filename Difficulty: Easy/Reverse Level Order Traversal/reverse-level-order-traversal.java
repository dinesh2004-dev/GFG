/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        Stack<Integer> st = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node node = q.poll();
            
            st.push(node.data);
            
            
            if(node.right != null){
                
                q.add(node.right);
            }
            if(node.left != null){
                
                q.add(node.left);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!st.isEmpty()){
            
            res.add(st.pop());
        }
        
        return res;
    }
}