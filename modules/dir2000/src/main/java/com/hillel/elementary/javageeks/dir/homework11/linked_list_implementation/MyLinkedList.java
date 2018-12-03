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
    Node currentNode = head;
    while (currentNode != null) {
      if (o == null ? currentNode.value ==null : o.equals(currentNode.value)) {
        return  true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return new NodeIterator();
  }

  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    Iterator<T> iterator = iterator();
    int pointer = 0;
    while (iterator.hasNext()) {
      array[pointer++] = iterator.next();
    }
    return array;
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return null;
  }

  //private <T1 super T> T1[] blaBlaBla(T1[] a) {
  //  return null;
  //}

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
        removeNode(currentNode);
        return  true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  private void removeNode(Node currentNode) {
    Node previousNode = currentNode.previous;
    if (previousNode != null) {
      previousNode.next = currentNode.next;
    } else {
      head = currentNode.next;
    }
    if (tail == currentNode) {
      tail = currentNode.next;
    }
    currentNode.previous = null;
    currentNode.next = null;
    size--;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    Iterator iterator = c.iterator();
    while (iterator.hasNext()) {
      Object object = iterator.next();
      if (!contains(object)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T i: c) {
      add(i);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    if (c.size() == 0) {
      return true;
    }

    Node nextNode = getNode(index);
    Node previousNode = nextNode.previous;
    for (T value: c) {
      Node newNode = new Node(previousNode, null, value);
      previousNode.next = newNode;
      previousNode = newNode;
    }

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

  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node currentNode = head;
    int pointer = 0;
    while (currentNode != null) {
      if (pointer++ == index ) {
        return  currentNode;
      }
      currentNode = currentNode.next;
    }
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

  private class NodeIterator implements Iterator {
    private Node currentNode;

    NodeIterator() {
      this.currentNode = head;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null && currentNode.next != null;
    }

    @Override
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      currentNode = currentNode.next;
      return currentNode;
    }

    @Override
    public void remove() {
      Node nextNode = currentNode.next;
      removeNode(currentNode);
      currentNode = nextNode;
    }
  }
}
