
class MinStack {
class Node{
    int val;
    Node next;
    int min;
    
    Node(int val,Node next,int min){
        this.val=val;
        this.next=next;
        this.min=min;
    }
}
    
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
        head=null;
    }
    
    public void push(int x) {
        if(head==null){
           head=new Node(x,null,x);
        }
        else{
            Node temp=head;
            int minNode=Math.min(x,temp.min);
            Node nextNode=new Node(x,head,minNode);
            head=nextNode;
        }
    }
    
    public void pop() {
        if(head!=null){
            head=head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
