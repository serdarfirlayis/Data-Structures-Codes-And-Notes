package org.serdarfirlayis.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(1) for put, get and remove
 * Space Complexity: O(N)
 */

public class MyHashMap2 {
    private static final int SIZE = 769;
    private List<Entry>[] table;

    public MyHashMap2() {
        table = new ArrayList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        table[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        if (table[index] == null) {
            return -1;
        }

        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }

        for (Entry entry : table[index]) {
            if (entry.key == key) {
                table[index].remove(entry);
                return;
            }
        }
    }

    private static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}