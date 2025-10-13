/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
        static int getMaxSumUtil(Node node, HashMap<Node, Integer> memo) {
        if (node == null) return 0;
        
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        // Calculate the maximum sum 
        // including the current node
        int include = node.data;
        
        if (node.left != null) {
            include += getMaxSumUtil(node.left.left, memo) + 
                    getMaxSumUtil(node.left.right, memo);
        }

        if (node.right != null) {
            include += getMaxSumUtil(node.right.left, memo) + 
                    getMaxSumUtil(node.right.right, memo);
        }

        // Calculate the maximum sum 
        // excluding the current node
        int exclude = getMaxSumUtil(node.left, memo) + 
                   getMaxSumUtil(node.right, memo);

        memo.put(node, Math.max(include, exclude));
        return memo.get(node);
    }

    static int getMaxSum(Node root) {
        HashMap<Node, Integer> memo = new HashMap<>();
        return getMaxSumUtil(root, memo);
    }
}