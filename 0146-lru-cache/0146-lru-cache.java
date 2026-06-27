class Node{
    int key, val;
    Node prev, next;

    public Node(){
        key = val = -1;
        prev = next = null;
    }

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        next = prev = null;
    }
}

class LRUCache {

    private Map<Integer, Node> map;
    private Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(); tail = new Node();
        head.next = tail;
        tail.prev = head;   
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        if(map.size() == capacity){
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
    }

    private void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertAfterHead(Node node){
        Node next = head.next;
        head.next = node;
        next.prev = node;
        node.prev = head;
        node.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */