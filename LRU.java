class LRUCache {
    Map<Integer,Node> node_map;
    int cache_capacity;
    final Node head=new Node();
    final Node tail=new Node();
    

    public LRUCache(int capacity) {
    node_map=new HashMap();
        cache_capacity=capacity;
        head.next=tail;
        tail.previous=head;
        
    }
    
    public int get(int key) {
        int result=-1;
        Node node=node_map.get(key);
        if(node!=null){
            remove(node);
            add(node);
            result=node.value;
        }
        return result;
    }
    
    public void put(int key, int value) {
        Node node=node_map.get(key);
        if(node!=null){
            remove(node);
            node.value=value;
            add(node);
        }else{
            // Node is not present so we need to declare a new node
            if(node_map.size()==cache_capacity){                                                    node_map.remove(tail.previous.key) 
                //remove from tail
                remove(tail.previous);
            
            }
            Node new_node=new Node();
            new_node.value=value;
            new_node.key=key;
            node_map.put(key,new_node);
            add(new_node);
        }
        
    }
    public void add(Node node){
        /*
        add the node at the front/head 
        head                            head_next    
        previous                        previous  
                        node
                        previous        
        */
        Node head_next=head.next;
                node.next=head_next;
        head_next.previous=node;

        head.next=node;
        node.previous=head;
        
    }
    public void remove(Node node){
        /*
        remove from the tail
        node_previous -> node -> node_next;
        
        */
                Node node_next=node.next;

        Node node_previous=node.previous;
        node_next.previous=node_previous;
                node_previous.next=node_next;

    }
    public class Node{
        int key;
        int value;
        Node next;
        Node previous;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
