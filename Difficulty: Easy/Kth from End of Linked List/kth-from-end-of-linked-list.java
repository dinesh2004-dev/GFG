/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node curr = head;
        
        int len = 0;
        
        while(curr != null){
            
            curr = curr.next;
            len++;
        }
        
        len = len - k;
        
        if(len < 0){
            
            return -1;
        }
        
        curr = head;
        
        for(int i = 0; i < len; i++){
            
            curr = curr.next;
        }
        
        return curr.data;
    }
}