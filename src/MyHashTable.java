public class MyHashTable<K, V> {

    public class HashNode<K, V>{
        private K key;
        private V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] buckets;
    private int size;

    public MyHashTable(){
        this(11);
    }

    public MyHashTable(int M){
        buckets = new HashNode[M];
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % buckets.length;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode(key, value);

        if(buckets[index] == null){
            buckets[index] = newNode;
        }
        else{
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }

        size++;

    }

    public V get(K key){
        int index = hash(key);

        HashNode<K, V> node = buckets[index];

        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }

            node = node.next;

        }

        return null;
    }

    public void remove(K key){

        int index = hash(key);
        HashNode<K, V> node = buckets[index];
        HashNode<K, V> prev = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = node.next;
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

    public boolean contains(V value){
        for (HashNode<K, V> head : buckets) {
            HashNode<K, V> node = head;
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;

    }

    public K getKey(V value){
        for (HashNode<K, V> head : buckets) {
            HashNode<K, V> node = head;
            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;


    }

    public HashNode<K, V>[] getBuckets() {
        return buckets;
    }


}