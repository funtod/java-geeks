package com.hillel.elementary.javageeks.examples.threads.notify;

public class Queue {
    private Cell head, tail; //элементы в "голове" и "хвосте" очереди

    public synchronized void add(Object obj) {
        Cell cell = new Cell(obj);
        if (tail == null)
            head = cell;
        else
            tail.next = cell;

        cell.next = null;
        tail = cell;
        notifyAll(); // в очередь добавлен элемент
    }

    public synchronized Object take() {
        while (head == null) {
            try {
                wait(); // Ждать уведомления о добавлении элемента
            } catch (InterruptedException e) {
                System.out.println("Wait on take() was interrupted");
            }
        }
        Cell cell = head; // запомнить элемент, занимающий место в "голове" очереди
        head = head.next; // Удалить элемент из "головы"  очереди

        if (head == null)  // проверить, не пуста ли очередь
            tail = null;

        return cell.item;
    }

    private static class Cell {
        Cell next;
        Object item;

        Cell(Object item){
            this.item = item;
        }
    }
}