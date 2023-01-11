import java.util.*;

/*
 * LRU generic with test
 * redundant head and tail
 * 
*/
// "static void main" must be defined in a public class.
public class main0146 {
    public static void main(String[] args) {
     
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.print();
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.print();
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.print();
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.print();
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.print();
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

class LRUCache<K, V> {
    static class Node<K, V> {
        K key;
        V val;
        Node prev, next;
        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public void printNode() {
            System.out.print("{" + key + "," + val + "}");
        }
    }
    
    Map<K, Node<K,V>> cache;
    Node<K, V> head, tail;
    int SIZE, capacity, count;
    public LRUCache(int capacity) {
        SIZE = capacity;
        cache = new HashMap<>();
        head = new Node("head", "head");
        tail = new Node("tail", "tail");
        head.next = tail;
        tail.prev = head;
    }
    
    public V get(K key) {
        if (cache.containsKey(key)) {
            Node<K, V> tmpNode = cache.get(key);
            swithHead(tmpNode);
            return tmpNode.val;
        } 
        return null;
    }
    
    public void swithHead(Node<K, V> tmpNode) {
        deleteNode(tmpNode);
        addHead(tmpNode);
    }
    
    private void deleteNode(Node<K, V> tmpNode) {
        Node next = tmpNode.next;
        Node prev = tmpNode.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    private void addHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node tmpNode = cache.get(key);
            tmpNode.key = key;
            tmpNode.val = value;
            swithHead(tmpNode);
            return;
        }
        Node newNode = new Node(key, value);
        while (cache.size() >= SIZE) {
            K tailVal = removeTail();
            cache.remove(tailVal);
            count--;
        } 
            count++;
            addHead(newNode);
            cache.put(key, newNode);
    
    }
    
    private K removeTail() {
        Node<K, V> prevTail = tail.prev;
        deleteNode(prevTail);
        return prevTail.key;
    }
    
    public void print() {
        Node<K, V> curr = head;
        while (curr != tail) {
            curr.printNode();
            curr = curr.next;
        }
        curr.printNode();
        System.out.println();
    }
}

class LRUCache_Generic {
    DList dList;
    int CAP;
    public LRUCache_Generic(int capacity) {
        this.CAP = capacity;
        dList = new DList(CAP);
    }
    
    public int get(int key) {
        Integer res = (Integer)dList.get(key);
        return res == null ? -1 : res;
    }
    
    public void put(int key, int value) {
        dList.set(key, value);
    }
}

class Node<K,V> {
    K key;
    V val;
    Node prev, next;
    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    public void update(K key, V val) {
        this.key = key;
        this.val = val;
    }
}

class DList<K,V> {
    private final int CAP;
    Map<K,Node<K,V>> map;
    private Node<K,V> head, tail;
    public DList(int num) {
        this.CAP = num;
        this.map = new HashMap<>();
        this.head = new Node(null, null);        
        this.tail = new Node(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public void set(K key, V val) {
        Node<K,V> node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = val;
            remove(node);
        } else if (map.size() < CAP) {
            node = new Node(key, val);
        } else {
            node = tail.prev;
            remove(node);
            node.update(key, val);
        }
        append(node);
    }
    
    public V get(K key) {
        Node<K,V> node = map.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        append(node);
        return node.val;
    }
    
    public Node<K,V> remove(Node<K,V> node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
        return node;
    }
    
    public Node<K,V> append(Node<K,V> node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */