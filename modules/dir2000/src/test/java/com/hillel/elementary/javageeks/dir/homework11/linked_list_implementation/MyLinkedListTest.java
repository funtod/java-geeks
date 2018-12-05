package com.hillel.elementary.javageeks.dir.homework11.linked_list_implementation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {
  private final String A_VALUE = "a";
  private final String B_VALUE = "b";
  private final String C_VALUE = "c";
  private final String D_VALUE = "d";
  private final int TEST_COLLECTION_SIZE = 3;

  /*Testing of size()*/

  @Test
  void shouldReturnCorrectSizeOnCreation() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    int result = list.size();
    int expectedSize = 3;

    //then
    assertEquals(expectedSize, result);

//    //when
//    int lastIndex = list.size() - 1;
//    list.remove(lastIndex);
//    result = list.size();
//    expectedSize = 2;
//
//    //then
//    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterValueAdding() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.add("new value");
    int result = list.size();
    int expectedSize = 4;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterRemovingExistingValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.remove(A_VALUE);
    int result = list.size();
    int expectedSize = 2;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterRemovingAbsentValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.remove("absent value");
    int result = list.size();
    int expectedSize = 3;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterAddingAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.addAll(createAdditionalCollection());
    int result = list.size();
    int expectedSize = 5;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterAddingAllByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.addAll(0, createAdditionalCollection());
    int result = list.size();
    int expectedSize = 5;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterRemovingAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.removeAll(createAdditionalCollection());
    int result = list.size();
    int expectedSize = 2;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterRetainingAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.retainAll(createAdditionalCollection());
    int result = list.size();
    int expectedSize = 1;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterClearing() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.clear();
    int result = list.size();
    int expectedSize = 0;

    //then
    assertEquals(expectedSize, result);
  }

  @Test
  void shouldReturnCorrectSizeAfterRemovingByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.remove(list.size() - 1);
    int result = list.size();
    int expectedSize = 2;

    //then
    assertEquals(expectedSize, result);
  }

  /*Testing of isEmpty()*/

  @Test
  void shouldReturnTrueIfIsEmpty() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.clear();
    boolean result = list.isEmpty();

    //then
    assertTrue(result);
  }

  /*Testing of contains()*/

  @Test
  void shouldContainExistingValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    String value = A_VALUE;
    boolean result = list.contains(value);

    //then
    assertTrue(result);
  }

  @Test
  void shouldNotContainAbsentValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Integer value = new Integer(7);
    boolean result = list.contains(value);

    //then
    assertFalse(result);
  }

  /*Testing of iterator()*/

  @Test
  void shouldReturnTrueIfIteratorHasNext() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Iterator iterator = list.iterator();
    boolean result = iterator.hasNext();

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnTheFirstValueByIfIterator() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Iterator iterator = list.iterator();
    Object result = iterator.next();
    String expectedValue = A_VALUE;

    //then
    assertEquals(result, expectedValue);
  }

  @Test
  void shouldIterateByIterator() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Iterator iterator = list.iterator();
    Object[] result = new Object[list.size()];
    int pointer = 0;
    while (iterator.hasNext()) {
      result[pointer++] = iterator.next();
    }
    int expectedSize = 3;
    Object[] expectedResult = createTestArray();

    //then
    assertArrayEquals(result, expectedResult);
  }

  @Test
  void shouldRemoveAllItemsByIterator() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      iterator.next();
      iterator.remove();
    }
    int result = list.size();
    int expectedSize = 0;

    //then
    assertEquals(result, expectedSize);
  }

  /*Testing of toArray()*/

  @Test
  void shouldReturnArrayOfTheSameType() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    Object[] result = list.toArray();
    Object[] expectedArray = createTestArray();

    //then
    assertArrayEquals(result, expectedArray);
  }

  @Test
  void shouldReturnArrayOfTheSpecifiedType() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    String[] result = list.toArray(new String[0]);
    String[] expectedArray = createTestArray();

    //then
    assertArrayEquals(result, expectedArray);
  }

  /*Testing of add()*/

  @Test
  void shouldAddValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.add(D_VALUE);
    String result = list.get(list.size() - 1);

    //then
    assertEquals(result, D_VALUE);
  }

  /*Testing of remove()*/

  @Test
  void shouldRemoveValue() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.remove(C_VALUE);
    String result = list.get(list.size() - 1);

    //then
    assertEquals(result, B_VALUE);
  }

  /*Testing of containsAll()*/

  @Test
  void shouldContainAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    boolean result = list.containsAll(Arrays.asList(A_VALUE, B_VALUE));

    //then
    assertTrue(result);
  }

  @Test
  void shouldNotContainAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    boolean result = list.containsAll(Arrays.asList(A_VALUE, D_VALUE));

    //then
    assertFalse(result);
  }

  /*Testing of addAll(Collection<? extends T> c)*/

  @Test
  void shouldAddAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    boolean result = list.addAll(Arrays.asList(A_VALUE, D_VALUE));
    String last = list.get(list.size() - 1);
    String beforeLast = list.get(list.size() - 2);

    //then
    assertTrue(result);
    assertEquals(last, D_VALUE);
    assertEquals(beforeLast, A_VALUE);
  }

  /*Testing of addAll(int index, Collection<? extends T> c)*/

  @Test
  void shouldAddAllByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    int index = 1;
    boolean result = list.addAll(index, Arrays.asList(A_VALUE, D_VALUE));
    String insertedValue = list.get(index);

    //then
    assertTrue(result);
    assertEquals(insertedValue, A_VALUE);
  }

  /*Testing of removeAll(Collection<?> c)*/

  @Test
  void removeAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    boolean result = list.removeAll(Arrays.asList(A_VALUE, D_VALUE));
    String insertedValue = list.get(0);

    //then
    assertTrue(result);
    assertEquals(insertedValue, B_VALUE);
  }

  /*Testing of retainAll(Collection<?> c)*/

  @Test
  void retainAll() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    boolean result = list.retainAll(Arrays.asList(A_VALUE, D_VALUE));
    String retainedValue = list.get(0);
    int size = list.size();
    int expectedSize = 1;

    //then
    assertTrue(result);
    assertEquals(retainedValue, A_VALUE);
    assertEquals(expectedSize, size);
  }

  /*Testing of clear()*/

  @Test
  void shouldClear() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.clear();

    //then
    assertTrue(list.isEmpty());
  }

  /*Testing of T get(int index)*/

  @Test
  void shouldGetByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    int indexTwo = 2;

    //then
    assertEquals(A_VALUE, list.get(0));
    assertEquals(B_VALUE, list.get(1));
    assertEquals(C_VALUE, list.get(indexTwo));
  }

  /*Testing of T set(int index, T element)*/

  @Test
  void shouldSetByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.set(0, D_VALUE);

    //then
    assertEquals(D_VALUE, list.get(0));
    assertEquals(TEST_COLLECTION_SIZE, list.size());
  }

  /*Testing of void add(int index, T element)*/

  @Test
  void shouldAddByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.add(1, D_VALUE);
    int indexTwo = 2;

    //then
    assertEquals(A_VALUE, list.get(0));
    assertEquals(D_VALUE, list.get(1));
    assertEquals(B_VALUE, list.get(indexTwo));
  }

  /*Testing of T remove(int index)*/

  @Test
  void shouldRemoveByIndex() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.remove(1);

    //then
    assertEquals(A_VALUE, list.get(0));
    assertEquals(C_VALUE, list.get(1));
  }

  /*Testing of int indexOf(Object o)*/

  @Test
  void indexOf() {
    //given
    MyLinkedList<String> list = createTestList();

    //then
    assertEquals(0, list.indexOf(A_VALUE));
    assertEquals(1, list.indexOf(B_VALUE));
    assertEquals(-1, list.indexOf(D_VALUE));
  }

  @Test
  void lastIndexOf() {
    //given
    MyLinkedList<String> list = createTestList();

    //when
    list.add(A_VALUE);
    int index = list.lastIndexOf(A_VALUE);
    int expectedIndex = 3;

    //then
    assertEquals(expectedIndex, index);
  }

  @Test
  void listIterator() {
  }

  @Test
  void listIterator1() {
  }

  @Test
  void subList() {
  }

  private MyLinkedList<String> createTestList() {
    MyLinkedList<String> list = new MyLinkedList<>();
    String[] array = createTestArray();
    for (int i = 0; i < array.length; i++) {
      list.add(array[i]);
    }
    return list;
  }

  private String[] createTestArray() {
    String[] array = new String[TEST_COLLECTION_SIZE];
    array[0] = A_VALUE;
    array[1] = B_VALUE;
    array[2] = C_VALUE;
    return array;
  }

  private List<String> createAdditionalCollection() {
    return Arrays.asList(new String[] {A_VALUE, D_VALUE});
  }
}