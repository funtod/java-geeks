package com.hillel.elementary.javageeks.dir.homework11.linked_list_implementation;


import java.util.*;

public class MyLinkedList<T> implements List<T> {
  private int size;
  private Node head;
  private Node tail;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return null;
  }

  @Override
  public boolean add(T t) {
    Node newNode = new Node(tail, null, t);
    if (size == 0) {
      head = newNode;
    }
    tail = newNode;

    size++;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    Node currentNode = head;
    while (currentNode != null) {
      if (o == null ? currentNode.value ==null : o.equals(currentNode.value)) {
        Node previousNode = currentNode.previous;
        if (previousNode != null) {
          previousNode.next = currentNode.next;
        } else {
          head = currentNode.next;
        }

        if (tail == currentNode) {
          tail = currentNode.previous;
        }

        currentNode.previous = null;
        currentNode.next = null;
        size--;
        return  true;
      }

      currentNode = currentNode.next;
    }
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    Iterator iterator = c.iterator();
    while (iterator.hasNext()) {
      Object object = iterator.next();
      if (!contains(object)) {
        return false;
      };
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public T set(int index, T element) {
    return null;
  }

  @Override
  public void add(int index, T element) {
    //Node new Node
  }

  @Override
  public T remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<T> listIterator() {
    return null;
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    return null;
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    return null;
  }

  private static class Node<T> {
    Node previous;
    Node next;
    T value;

    public Node(Node argPrevious, Node argNext, T argValue) {
      previous = argPrevious;
      next = argNext;
      value = argValue;
    }
  }
}
