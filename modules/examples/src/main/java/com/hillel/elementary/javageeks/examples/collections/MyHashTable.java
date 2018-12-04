package com.hillel.elementary.javageeks.examples.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashTable implements Map {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE / 2;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private float loadFactor;
    private Node[] buckets;
    private int threshold;

    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashTable(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashTable(int capacity, float loadFactor) {
        buckets = new Node[capacity];
        this.loadFactor = loadFactor;
        threshold = (int) (capacity * loadFactor);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {

        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);

        Node node = buckets[bucketIndex];

        while (node != null) {
            if (node.key == key
                    || (node.key != null && node.key.equals(key))) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);
        Node rootNode = buckets[bucketIndex];

        if (rootNode == null) {
            Node node = new Node(key, value, hash, null);
            buckets[bucketIndex] = node;
        } else {
            Node prev = null;
            while (rootNode != null) {
                if (rootNode.key == key
                        || (rootNode.key != null && rootNode.key.equals(key))) {
                    Object oldValue = rootNode.value;
                    rootNode.value = value;
                    return oldValue;
                } else {
                    prev = rootNode;
                    rootNode = rootNode.next;
                }
            }
            Node node = new Node(key, value, hash, null);
            prev.next = node;
        }

        size++;
        resize();
        return null;
    }

    private void resize() {
        if (size < threshold) {
            return;
        }

        int newCapacity = buckets.length * 2;
        if (newCapacity > MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }

        Node[] newBuckets = new Node[newCapacity];

        for (int i = 0; i < buckets.length; i++) {
            Node node = buckets[i];
            while (node != null) {
                int bucketIndex = getBucketIndex(node.hash);
                Node rootNode = newBuckets[bucketIndex];
                Node nodeToAdd = new Node(node.key, node.value, node.hash, null);

                if (rootNode == null) {
                    newBuckets[bucketIndex] = nodeToAdd;
                } else {
                    while (rootNode.next != null) {
                        rootNode = rootNode.next;
                    }
                    rootNode.next = nodeToAdd;
                }

                node = node.next;
            }
        }

        this.buckets = newBuckets;
    }

    private int getBucketIndex(int hash) {
        return Math.abs(hash % (buckets.length));
    }

    private int getHash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    private static class Node {
        Object key;
        Object value;
        Node next;
        int hash;

        public Node(Object key, Object value, int hash, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }
    }
}
