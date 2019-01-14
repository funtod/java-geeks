package com.hillel.elementary.javageeks.dir.concurrency.atomics;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleNonBlockingQueue<T> extends AbstractQueue<T> {
    private AtomicReference<Node<T>> tail = new AtomicReference<>(null);
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
            Node<T> last = tail.get();
            Node<T> node = new Node<>(value, last);

            if (tail.compareAndSet(last, node)) {
                size.incrementAndGet();
                return true;
            }
        }
    }

    @Override
    public T poll() {
        while(true) {
            Node<T> last = tail.get();
            if (last == null) return null;

            if (last.next == null) {
                if (tail.compareAndSet(last, null)) {
                    size.decrementAndGet();
                    return last.value;
                }
            } else {
                Node<T> currNode = last;
                Node<T> newFirst = new Node<>(last.value, null);
                Node<T> newCurrNode = newFirst;
                T valueToReturn = currNode.next.value;
                while (currNode.next.next != null) {
                    newCurrNode.next = new Node<>(currNode.next.value, null);
                    newCurrNode = newCurrNode.next;

                    currNode = currNode.next;
                    valueToReturn = currNode.next.value;
                }
                if (tail.compareAndSet(last, newFirst)) {
                    size.decrementAndGet();
                    return valueToReturn;
                }
            }
        }
    }

    @Override
    public T peek() {
        Node<T> node = tail.get();
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
