package org.serdarfirlayis.leetcode;

public class MyHashMap<K, V> {

    public static void main(String[] args) {
        // Test cases can be added here
    }

    private static final int SIZE = 5;
    private Entry<K, V>[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % SIZE;
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
        int index = hash % SIZE;
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null;
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
    }
}
