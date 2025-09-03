/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        
        Node prev = null;
        Node curr = head;
        
        while(curr != null){
            Node next = curr.next;
            prev = curr.prev;
            curr.prev = next;
            curr.next = prev;
            if(next == null){
                break;
            }
            curr = next;
        }
        
        return curr;
    }
}