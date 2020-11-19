// In this solution, push is O(N), pop is O(1)

class MyQueue {
    LinkedList<Integer> mystack1=new LinkedList();
    LinkedList<Integer> mystack2=new LinkedList();
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(mystack1.isEmpty()){
            mystack1.push(x);
        }
        else{
            while(!mystack1.isEmpty()){
             mystack2.push(mystack1.pop());
            }
                         mystack1.push(x);
            while(!mystack2.isEmpty()){
                mystack1.push(mystack2.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return mystack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return mystack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mystack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
