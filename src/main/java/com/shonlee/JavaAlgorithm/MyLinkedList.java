package com.shonlee.JavaAlgorithm;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by ShonLee on 2017/6/13.
 * LinkedList类里面较重要的方法就是"addBefore(){}"和"private void remove(DNode <T> curr){}"
 * 很多方法都与它俩有关系!!
 * 下面的代码是个双向循环链表
 */
public class MyLinkedList<T> {
    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private DNode<T> header;
    private int listSize;

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public MyLinkedList() {
        header = new DNode<T>();
        listSize = 0;
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private static class DNode<T> {
        T nodeValue;
        DNode<T> prev;
        DNode<T> next;

        public DNode() { // for header
            nodeValue = null;
            prev = this; // left
            next = this; // right
        }

        public DNode(T item) {
            nodeValue = item;
            prev = this;
            next = this;
        }
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public boolean isEmpty() {
        return (header.prev == header || header.next == header);
    }

    public int size() {
        return listSize;
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private DNode<T> addBefore(DNode<T> curr, T item) {
        DNode<T> newNode, prevNode;
        newNode = new DNode<T>(item);

        prevNode = curr.prev;

        newNode.prev = prevNode;
        newNode.next = curr;

        prevNode.next = newNode;
        curr.prev = newNode;
        return newNode;
    }

    public boolean add(T item) {
        addBefore(header, item);
        listSize++;
        return true;
    }

    public void addFirst(T item) {
        addBefore(header.next, item);
        listSize++;
    }

    public void addLast(T item) {
        addBefore(header, item);
        listSize++;
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private void remove(DNode<T> curr) {
        if (curr.next == curr) return;

        DNode<T> prevNode = curr.prev, nextNode = curr.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public boolean remove(Object o) {
        for (DNode<T> p = header.next; p != header; p = p.next) {
            if (o.equals(p.nodeValue)) {
                remove(p);
                listSize--;
                return true;
            }
        }
        return false;
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public void printList() {
        for (DNode<T> p = header.next; p != header; p = p.next)
            System.out.println(p.nodeValue);
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private class MyIterator implements Iterator<T> {

        public DNode<T> nextNode = header.next;
        public DNode<T> lastReturned = header;

        public boolean hasNext() {
            return nextNode != header;
        }

        public T next() {
            if (nextNode == header)
                throw new NoSuchElementException("");

            lastReturned = nextNode;
            nextNode = nextNode.next;
            return lastReturned.nodeValue;
        }

        public void remove() {
            if (lastReturned == header)
                throw new IllegalStateException("");

            MyLinkedList.this.remove(lastReturned);
            lastReturned = header;
            listSize--;
        }
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private class MyListIterator extends MyIterator implements ListIterator<T> {

        private int nextIndex;

        MyListIterator(int index) {
            if (index < 0 || index > listSize)
                throw new IndexOutOfBoundsException("");

            //如果index小于listSize/2，就从表头开始查找定位，否则就从表尾开始查找定位
            if (index < (listSize >> 1)) {
                nextNode = header.next;
                for (nextIndex = 0; nextIndex < index; nextIndex++)
                    nextNode = nextNode.next;
            } else {
                nextNode = header;
                for (nextIndex = listSize; nextIndex > index; nextIndex--)
                    nextNode = nextNode.prev;
            }
        }

        public boolean hasPrevious() {
            return nextIndex != 0;
            //return nextNode.prev != header;
        }

        public T previous() {
            if (nextIndex == 0)
                throw new NoSuchElementException("no");

            lastReturned = nextNode = nextNode.prev;
            nextIndex--;
            return lastReturned.nodeValue;
        }

        public void remove() {
            if (lastReturned == header)
                throw new IllegalStateException("");

            MyLinkedList.this.remove(lastReturned);
            nextIndex--;
            listSize--;

            if (lastReturned == nextNode)
                nextNode = nextNode.next;
            lastReturned = header;
        }

        public void add(T item) {
            MyLinkedList.this.addBefore(nextNode, item);
            nextIndex++;
            listSize++;
            lastReturned = header;
        }

        public void set(T item) {
            if (lastReturned == header)
                throw new IllegalStateException();

            lastReturned.nodeValue = item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }

    //～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public static void main(String[] args) {
        MyLinkedList<String> t = new MyLinkedList<String>();
        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        //t.remove("B");
        //t.addFirst("AA");
        //t.addLast("BB");
        //t.printList();


        ListIterator<String> it = t.listIterator(t.size());

        while (it.hasPrevious()) {
            System.out.println(it.previous()); // D C B A
        }
    }
}
