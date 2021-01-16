class LFUCache {
    class Node{
        int key;
        int value;
        int count;
        Node previous,next;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            count=1;
        }
    }
    class DDList{
        Node head,tail;
        int length;
        public DDList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.previous=head;
            length=0;
        }
        
        public void addHead(Node node){  
            Node node_next=head.next;
            head.next=node;
            node.previous=head;
            node.next=node_next;
            node_next.previous=node;
            map.put(node.key,node);
            length++;            
        }
        public void remove(Node node){
            Node node_previous=node.previous;
            Node node_next=node.next;
            node_previous.next=node_next;
            node_next.previous=node_previous;
            map.remove(node.key,node);
            length--;
        }
        public void removeTail(){
            Node previousTail=tail.previous;
            remove(previousTail);
        }
        
    }
    Map<Integer,Node> map;
    Map<Integer,DDList>freq;
    int size,capacity;
    int maxFreq;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        freq=new HashMap<>();
        size=0;
        maxFreq=0;
    }
    
    public int get(int key) {
        Node node=map.get(key);
        if(node==null){
            return -1;
        }
        int prevFreq=node.count;
        DDList prevFreqList=freq.get(prevFreq);
        prevFreqList.remove(node);
        
        int currentFreq=prevFreq+1;
        maxFreq=Math.max(maxFreq,currentFreq);
        DDList currentFreqList=freq.getOrDefault(currentFreq,new DDList());
        node.count++;
        currentFreqList.addHead(node);
        freq.put(prevFreq,prevFreqList);
        freq.put(currentFreq,currentFreqList);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.get(key)!=null){
            map.get(key).value=value;
            get(key);
            return;
        }
        
        Node node=new Node(key,value);
        DDList currentList=freq.getOrDefault(1,new DDList());
        currentList.addHead(node);
        size++;
        if(size>capacity){
            if(currentList.length>1){
                currentList.removeTail();
            }
            else{
                for(int i=2;i<=maxFreq;i++){
                    if(freq.get(i)!=null &&freq.get(i).length>0){
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1,currentList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
