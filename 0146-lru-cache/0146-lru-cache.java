class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer,Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node add){
        add.next = head.next;
        add.prev = head;
        head.next.prev = add;
        head.next = add;
    }

    public void removeNode(Node del){
        Node delPrev = del.prev;
        Node delNext = del.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        int val = node.value;
        
        removeNode(node);
        addNode(node);
        
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
            return;
        }

        if(map.size() == cap){
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */