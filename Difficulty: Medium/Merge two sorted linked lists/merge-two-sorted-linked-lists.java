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
        
        Node curr1 = head1,curr2 = head2,currDum = dummy;
        
        while(curr1 != null && curr2 != null){
            
            if(curr1.data < curr2.data){
                
                Node newNode = new Node(curr1.data);
                currDum.next = newNode;
                curr1 = curr1.next;
            }
            else{
                
                Node newNode = new Node(curr2.data);
                currDum.next = newNode;
                curr2 = curr2.next;
            }
            
            currDum = currDum.next;
        }
        
        while(curr1 != null){
            
            Node newNode = new Node(curr1.data);
            currDum.next = newNode;
            currDum = currDum.next;
            
            curr1 = curr1.next;
        }
        while(curr2 != null){
            
            Node newNode = new Node(curr2.data);
            currDum.next = newNode;
            currDum = currDum.next;
            
            curr2 = curr2.next;
        }
        
        return dummy.next;
    }
}