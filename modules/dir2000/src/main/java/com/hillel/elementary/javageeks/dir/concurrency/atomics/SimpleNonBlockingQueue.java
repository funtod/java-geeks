package com.hillel.elementary.javageeks.dir.concurrency.atomics;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleNonBlockingQueue<T> extends AbstractQueue<T> {
    private AtomicReference<Node<T>> head = new AtomicReference<>(null);
    private AtomicInteger size = new AtomicInteger(0);

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size.get();
    }

    @Override
    public boolean offer(T value) {
        if (value == null) throw new IllegalArgumentException();
        while (true) {
            Node<T> first = head.get();
            Node<T> node = new Node<>(value, first);

            if (head.compareAndSet(first, node)) {
                size.incrementAndGet();
                return true;
            }
        }
    }

    @Override
    public T poll() {
        while(true) {
            Node<T> first = head.get();
            if (first == null) return null;

            if (first.next == null) {
                if (head.compareAndSet(first, null)) {
                    size.decrementAndGet();
                    return first.value;
                }
            } else {
                Node<T> currNode = first;
                Node<T> newFirst = new Node<>(first.value, null);
                Node<T> newCurrNode = newFirst;
                T valueToReturn = currNode.next.value;
                while (currNode.next.next != null) {
                    newCurrNode.next = new Node<>(currNode.next.value, null);
                    newCurrNode = newCurrNode.next;

                    currNode = currNode.next;
                    valueToReturn = currNode.next.value;
                }
                if (head.compareAndSet(first, newFirst)) {
                    size.decrementAndGet();
                    return valueToReturn;
                }
            }
        }
    }

    @Override
    public T peek() {
        Node<T> node = head.get();
        if (node == null) return null;
        while (node.next != null) {
            node = node.next;
        }

        return node.value;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
