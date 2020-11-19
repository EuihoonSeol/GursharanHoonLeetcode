class MyStack {
    Queue<Integer> main=new LinkedList();
    Queue<Integer> temp=new LinkedList();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while(!main.isEmpty()){
            temp.add(main.remove());
        }
        main.add(x);
        while(!temp.isEmpty()){
            main.add(temp.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return main.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return main.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
