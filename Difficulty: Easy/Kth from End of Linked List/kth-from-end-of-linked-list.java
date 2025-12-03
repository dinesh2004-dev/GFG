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
        
        if(k > len){
            
            return -1;
        }
        
        len = len -  k;
        
        curr = head;
        
        
        
        for(int i = 0; i < len; i++){
            
            curr = curr.next;
        }
        
        // Node temp = curr.next;
        
        // curr.next = temp.next;
        
        // temp.next = null;
        
        return curr.data;
    }
}