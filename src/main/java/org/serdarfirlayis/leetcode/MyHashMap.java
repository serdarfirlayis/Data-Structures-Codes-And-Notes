package org.serdarfirlayis.leetcode;

public class MyHashMap<K, V> {

    public static void main(String[] args) {
         // Create an instance of MyHashMap
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        // Test 1: Adding key-value pairs
        myHashMap.put("apple", 100);
        myHashMap.put("banana", 200);
        myHashMap.put("cherry", 300);
        System.out.println("After adding values:");
        System.out.println(myHashMap);

        // Test 2: Updating the value of an existing key
        myHashMap.put("apple", 150);
        System.out.println("After updating the value of 'apple':");
        System.out.println(myHashMap);

        // Test 3: Retrieving the value of keys
        System.out.println("Value of 'banana': " + myHashMap.get("banana")); // Expected: 200
        System.out.println("Value of 'orange': " + myHashMap.get("orange")); // Expected: null (non-existent key)

        System.out.println();

        // Test 4: Removing an existing key
        System.out.println("Removing 'cherry': " + myHashMap.remove("cherry"));
        System.out.println("After removing 'cherry':");
        System.out.println(myHashMap);

        // Test 5: Attempting to remove a non-existent key
        System.out.println("Removing 'grape': " + myHashMap.remove("grape")); // Expected: null

        // Test 6: Handling collisions (keys that map to the same index)
        myHashMap.put("dog", 500);
        myHashMap.put("god", 600); // Potential hash collision with 'dog'
        System.out.println("After adding 'dog' and 'god' with potential collision:");
        System.out.println(myHashMap);
    }

    private static final int SIZE = 5;
    private Entry<K, V>[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = Math.abs(hash % SIZE);
        Entry<K, V> entry = table[index];

        if (entry == null) {
            table[index] = new Entry<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }

            entry.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % SIZE);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null;
    }

    public Entry<K, V> remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % SIZE);
        Entry<K, V> entry = table[index];

        if (table[index] == null) {
            return null;
        }

        if(entry.getKey().equals(key)){
            table[index] = entry.next;
            entry.next = null;
            return entry;
        }

        Entry<K, V> prev = entry;
        entry = entry.next;

        while(entry != null) {
            if(entry.getKey().equals(key)) {
                prev.next = entry.next;
                entry.next = null;
                return entry;
            }
            prev = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if(table[i] != null) {
                sb.append(i).append(" ").append(table[i]).append("\n");
            } else {
                sb.append(i).append(" ").append("null").append("\n");
            }
        }
        return sb.toString();
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            Entry<K, V> temp = this;
            StringBuilder sb = new StringBuilder();
            while(temp != null) {
                sb.append(temp.key).append(" -> ").append(temp.value).append(",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
}
