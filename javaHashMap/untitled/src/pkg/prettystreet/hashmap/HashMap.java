package pkg.prettystreet.hashmap;

public class HashMap <K,V> implements IHashMap<K,V>  {

    private static final int DEFAULT_CAPACITY = 5;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;


    static class Node <K,V> {
        private int hash;
        private K key;
        private V value;
        Node<K,V> next;

        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
        public int getHash() {
            return this.hash;
        }
        public void setHash(int hash) {
            this.hash = hash;
        }
        public K getKey() {
            return this.key;
        }
        public void setKey(K key) {
            this.key = key;
        }
        public V getValue() {
            return this.value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public Node<K,V> getNext() {
            return this.next;
        }
        public void setNext(Node<K,V> node) {
            this.next = node;
        }
    }
    Node <K, V>[] table;

    float loadFactor;
    int capacity;

    int size;
    public HashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Node<K, V>[]) (new Node[capacity]);
    }
    public int hash(K key) {
        return key.hashCode() % this.capacity;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public void resize() {
        int newCapacity = capacity * 2;
        Node<K,V>[] newTable = new Node[newCapacity];
        for(int i = 0; i < capacity; i++) {
            Node<K,V> node = table[i];
            while (node != null) {
                Node<K,V> next = node.next;
                int index = hash(node.key);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    @Override
    public boolean containsValue(V value) {
        for (Node<K,V> node: table) {
            Node<K,V> curr = node;
            while (curr != null) {
                if (node.value == value) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = key.hashCode();

        for (Node<K,V> node: table) {
            Node<K,V> curr = node;
            while (curr != null) {
                if (node.hash == key.hashCode()) {
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        int indexOfBucket = hash(key);

        int count = 0;

        Node<K,V> currNode = table[indexOfBucket];

        while(currNode != null) {
            if (currNode.getHash() == key.hashCode()) {
                currNode.setValue(value);
                return;
            }
            count++;
            currNode = currNode.getNext();
        }
        Node<K,V> newNode = new Node<>(key, value, key.hashCode());
        newNode.setNext(table[indexOfBucket]);
        table[indexOfBucket] = newNode;
        size++;
        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public void print() {
            for (Node<K,V> node : table) {
            Node<K,V> n = node;
            while (n != null) {
                System.out.println(n.getKey() + " " + n.getValue());
                n = node.next;
                if (n == null) {
                    return;
                }
            }
        }
    }
}
