/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node current;
    public Node flatten(Node head) {
        Stack<Node> mystack=new Stack<>();
        if(head==null){
            return null;
        }        
        current=new Node(0,null,null,null);
        Node result=current; 
        mystack.push(head);
        while(!mystack.empty()){
            Node mynode=mystack.pop();
            current.val=mynode.val;
            current.next=new Node(0,current,null,null);
            current=current.next;
            if(mynode.next!=null){
                mystack.push(mynode.next);
            }
            if(mynode.child!=null){
                mystack.push(mynode.child);
            }                        
        }        
        current.prev.next=null;                
        return result;
    }
}
