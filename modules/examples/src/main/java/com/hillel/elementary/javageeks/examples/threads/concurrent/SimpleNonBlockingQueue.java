package com.hillel.elementary.javageeks.examples.threads.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleNonBlockingQueue<T> {

    private AtomicInteger size = new AtomicInteger(0);
    private AtomicReference<Node<T>> head = new AtomicReference<>(null);

    public int size() {
        return size.get();
    }

    public boolean isEmpty() {
        return size.get() == 0;
    }

    public boolean add(T element) {
        if (element == null) throw new IllegalArgumentException("Nulls are not allowed");

        if (head.get() == null) {
            if (head.compareAndSet(null, new Node<>(element))) {
                size.incrementAndGet();
                return true;
            }
        }

        while(true) {
            Node<T> first = head.get();
            Node<T> node = new Node<>(element);
            node.next.set(first);

            if (head.compareAndSet(first, node)) {
                size.incrementAndGet();
                return true;
            }
        }
    }


    public T remove() {
        return poll();
    }


    public T poll() {

        while (true) {
            Node<T> currentNode = head.get();
            Node<T> prevNode = null;

            if (currentNode == null) return null;

            while (currentNode != null && currentNode.next.get() != null) {
                prevNode = currentNode;
                currentNode = currentNode.next.get();
            }

            if (currentNode != null && prevNode != null) {
                if (prevNode.next.compareAndSet(currentNode, null)) {
                    size.decrementAndGet();
                    return currentNode.value;
                }
            } else {
                if (head.compareAndSet(currentNode, null)) {
                    size.decrementAndGet();
                    return currentNode.value;
                }
            }
        }
    }


    public T peek() {
        Node<T> first = head.get();
        return first == null ? null : first.value;
    }


    final static class Node<T> {
        final T value;
        final AtomicReference<Node<T>> next = new AtomicReference<>(null);

        Node(T value) {
            this.value = value;
        }
    }
}
