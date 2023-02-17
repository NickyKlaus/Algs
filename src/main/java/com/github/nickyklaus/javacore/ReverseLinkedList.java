package com.github.nickyklaus.javacore;

import java.util.Arrays;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Integer[] values = {0, 4, 1, 9, 6, 1, 0, 5, 5, 1};
        LinkedList<Integer> originalList = new LinkedList<>(values);
        System.out.println("ORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == 0 && originalList.getLast() == 1);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == 1 && originalList.getLast() == 0);

        Integer[] empty = {};
        originalList = new LinkedList<>(empty);
        System.out.println("\nORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        Integer[] single = {1};
        originalList = new LinkedList<>(single);
        System.out.println("\nORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst().equals(originalList.getLast()) && originalList.getFirst() == 1);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst().equals(originalList.getLast()) && originalList.getFirst() == 1);

        Integer[] singleWithNull = {null};
        originalList = new LinkedList<>(singleWithNull);
        System.out.println("\nORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        Integer[] multipleNulls = {null, null, null};
        originalList = new LinkedList<>(multipleNulls);
        System.out.println("\nORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == null);

        Integer[] multipleMixedWithNulls = {7, null, 0, 5, null, 3, null};
        originalList = new LinkedList<>(multipleMixedWithNulls);
        System.out.println("\nORIGINAL LIST:");
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == 7 && originalList.getLast() == null);

        System.out.println("REVERSED LIST:");
        originalList.reverse();
        System.out.println(originalList);
        System.out.println(originalList.getFirst() == null && originalList.getLast() == 7);
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
            if (size == 0 || first.getNext() == null) {
                return;
            }

            LinkedList.Node<E> tmp;
            LinkedList.Node<E> prev = null;
            LinkedList.Node<E> curr = first;

            while (curr != null) {
                tmp = curr.getNext();
                curr.setNext(prev);
                if (prev == null) {
                    setLast(curr);
                }
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
                last.setNext(node);
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

        public E getFirst() {
            return first == null ? null : first.getValue();
        }

        public E getLast() {
            return last == null ? null : last.getValue();
        }

        private void setFirst(Node<E> first) {
            this.first = first;
        }

        private void setLast(Node<E> node) {
            this.last = node;
        }

        @Override
        public String toString() {
            StringBuilder representation = new StringBuilder("LinkedList:\n").append("[ ");
            Node<E> curr = first;
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
