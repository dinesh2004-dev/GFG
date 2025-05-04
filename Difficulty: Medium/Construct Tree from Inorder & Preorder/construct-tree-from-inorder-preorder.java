//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int[] preIdx,int[] preOrder,Map<Integer,Integer>
    mpp,int l,int h){
        
        if(l > h){
            
            return null;
        }
        
        int val = preOrder[preIdx[0]];
        
        Node node = new Node(val);
        
        preIdx[0]++;
        
        int i = mpp.get(val);
        
        node.left = buildTree(preIdx,preOrder,mpp,l,i - 1);
        
        node.right = buildTree(preIdx,preOrder,mpp,i + 1,h);
        
        return node;
        
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        int[] preIdx = new int[]{0};
        
        Map<Integer,Integer> mpp = new HashMap<>();
        
        for(int i =  0; i < inorder.length; i++){
            
            mpp.put(inorder[i],i);
        }
        
        return buildTree(preIdx,preorder,mpp,0,preorder.length - 1);
    }
}
