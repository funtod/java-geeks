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
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (o == null ? currentNode.value == null : o.equals(currentNode.value)) {
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
  @SuppressWarnings("unchecked")
  public <T1> T1[] toArray(T1[] a) {
    if (a.length < size) {
      a = (T1[]) java.lang.reflect.Array.newInstance(
              a.getClass().getComponentType(), size);
    }
    Iterator<T> iterator = iterator();
    int pointer = 0;
    while (iterator.hasNext()) {
      a[pointer++] = (T1) iterator.next();
    }
    if (a.length > size) {
      a[size] = null;
    }

    return a;
  }

  @Override
  public boolean add(T t) {
    Node<T> newNode = new Node<>(tail, null, t);
    if (size == 0) {
      head = newNode;
    }
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;

    size++;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (o == null ? currentNode.value == null : o.equals(currentNode.value)) {
        removeNode(currentNode);
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
      return false;
    }

    Node<T> nextNode = getNodeByIndex(index);
    Node<T> previousNode = nextNode.previous;
    for (T value: c) {
      Node<T> newNode = new Node(previousNode, null, value);
      if (previousNode == null) {
        head = newNode;
      } else {
        previousNode.next = newNode;
      }
      previousNode = newNode;
      size++;
    }

    previousNode.next = nextNode;
    nextNode.previous = previousNode;

    return true;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    for (Object i: c) {
      remove(i);
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    Node<T> node = head;
    boolean modified = false;
    while (node != null) {
      if (!c.contains(node.value)) {
        removeNode(node);
        modified = true;
      }
      node = node.next;
    }
    return  modified;
  }

  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public T get(int index) {
    Node<T> node = getNodeByIndex(index);
    return node.value;
  }

  @Override
  public T set(int index, T element) {
    Node<T> node = getNodeByIndex(index);
    T oldValue = node.value;
    node.value = element;
    return oldValue;
  }

  @Override
  public void add(int index, T element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node<T> nextNode = getNodeByIndex(index);
    Node<T> previousNode = nextNode.previous;

    Node<T> newNode = new Node(previousNode, nextNode, element);
    if (previousNode == null) {
      head = newNode;
    } else {
      previousNode.next = newNode;
    }

    nextNode.previous = newNode;
    size++;
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    Node<T> node = getNodeByIndex(index);
    return removeNode(node);
  }

  @Override
  public int indexOf(Object o) {
    Node<T> node = head;
    int index = 0;
    while (node != null) {
      if (o == null ? node.value == null : o.equals(node.value)) {
        return index;
      }
      node = node.next;
      index++;
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    Node<T> node = tail;
    int index = size - 1;
    while (node != null) {
      if (o == null ? node.value == null : o.equals(node.value)) {
        return index;
      }
      node = node.previous;
      index--;
    }
    return -1;
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

  private Node getNodeByIndex(int index) {
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

  private T removeNode(Node<T> node) {
    Node<T> previousNode = node.previous;
    if (previousNode == null) {
      head = node.next;
    } else {
      previousNode.next = node.next;
    }

    Node<T> nextNode = node.next;
    if (nextNode == null) {
      tail = node.previous;
    } else {
      nextNode.previous = node.previous;
    }

    size--;

    return node.value;
  }

  private static class Node<T> {
    Node previous;
    Node next;
    T value;

    @Override
    public String toString() {
      return "Node(" + value + ")";
    }

    public Node(Node argPrevious, Node argNext, T argValue) {
      previous = argPrevious;
      next = argNext;
      value = argValue;
    }
  }

  private class NodeIterator implements Iterator {
    private Node<T> node;
    private Node<T> nodeToRemove;

    @Override
    public boolean hasNext() {
      if (head == null) {
        return false;
      }
      if (node == tail) {
        return false;
      }
      return node == null || node.next != null;
    }

    @Override
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      if (node == null) {
        node = head;
      } else {
        node = node.next;
      }
      nodeToRemove = node;
      return node.value;
    }

    @Override
    public void remove() {
      if (nodeToRemove == null) {
        throw new IllegalStateException();
      }
      Node<T> previousNode = node.previous;
      removeNode(node);
      nodeToRemove = null;
      node = previousNode;
    }
  }

  private class NodeListIterator implements ListIterator {
    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public Object next() {
      return null;
    }

    @Override
    public boolean hasPrevious() {
      return false;
    }

    @Override
    public Object previous() {
      return null;
    }

    @Override
    public int nextIndex() {
      return 0;
    }

    @Override
    public int previousIndex() {
      return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Object argO) {

    }

    @Override
    public void add(Object argO) {

    }
  }
}
