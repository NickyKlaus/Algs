package com.github.nickyklaus.javacore;

import java.util.Arrays;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Integer[] values = {0, 4, 1, 9, 6, 1, 0, 5, 5, 1};
        LinkedList<Integer> originalList = new LinkedList<>(values);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);

        Integer[] empty = {};
        originalList = new LinkedList<>(empty);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);

        Integer[] single = {1};
        originalList = new LinkedList<>(single);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);

        Integer[] singleWithNull = {null};
        originalList = new LinkedList<>(singleWithNull);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);

        Integer[] multipleNulls = {null, null, null};
        originalList = new LinkedList<>(multipleNulls);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);

        Integer[] multipleMixedWithNulls = {7, null, 0, 5, null, 3, null};
        originalList = new LinkedList<>(multipleMixedWithNulls);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
    }

    static class LinkedList<E> {
        private int size;
        private Node<E> first;
        private Node<E> last;

        public LinkedList() {
        }

        public LinkedList(E[] arr) {
            this(Arrays.asList(arr));
        }

        public LinkedList(Iterable<E> iterable) {
            this();
            for (E e : iterable) {
                add(e);
            }
        }

        public void reverse() {
            if (size == 0 || getFirst().getNext() == null) {
                return;
            }

            LinkedList.Node<E> tmp;
            LinkedList.Node<E> prev = null;
            LinkedList.Node<E> curr = getFirst();

            while (curr != null) {
                tmp = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                if (tmp == null)
                    setFirst(curr);
                curr = tmp;
            }
        }

        private boolean addNode(Node<E> node) {
            if (size == 0) {
                setFirst(node);
            } else {
                getLast().setNext(node);
            }
            setLast(node);
            incrementSize();
            return true;
        }

        public boolean add(E element) {
            return addNode(new Node<>(null, element));
        }

        private void incrementSize() {
            size++;
        }

        public int size() {
            return size;
        }

        private Node<E> getLast() {
            return last;
        }

        private void setLast(Node<E> node) {
            this.last = node;
        }

        private Node<E> getFirst() {
            return first;
        }

        private void setFirst(Node<E> first) {
            this.first = first;
        }

        @Override
        public String toString() {
            StringBuilder representation = new StringBuilder("LinkedList:\n").append("[ ");
            Node<E> curr = getFirst();
            while (curr != null) {
                representation.append(curr);
                if (curr.getNext() != null) {
                    representation.append(" -> ");
                }
                curr = curr.getNext();
            }
            return representation.append(" ]").toString();
        }

        private static class Node<T> {
            private Node<T> next;
            private T value;

            public Node(Node<T> next, T value) {
                this.next = next;
                this.value = value;
            }

            Node<T> getNext() {
                return next;
            }

            void setNext(Node<T> next) {
                this.next = next;
            }

            T getValue() {
                return value;
            }

            void setValue(T value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return value == null ? null : value.toString();
            }
        }
    }
}
