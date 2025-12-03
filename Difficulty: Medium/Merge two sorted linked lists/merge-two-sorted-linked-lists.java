/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node dummy = new Node(-1);
        
        Node tail = dummy;
        
        Node curr1 = head1,curr2 = head2;
        
        while(curr1 != null && curr2 != null){
            
            if(curr1.data < curr2.data){
                
                tail.next = curr1;
                curr1 = curr1.next;
            }
            else{
                
                tail.next = curr2;
                curr2 = curr2.next;
            }
            
            tail = tail.next;
        }
        
        if(curr1 != null){
            
            tail.next = curr1;
        }
        else{
            tail.next = curr2;
        }
        
        return dummy.next;
    }
}