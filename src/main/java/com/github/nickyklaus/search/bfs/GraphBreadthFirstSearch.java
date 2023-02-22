package com.github.nickyklaus.search.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class GraphBreadthFirstSearch {
    public static void main(String[] args) {
        /*
        root->n1->n3->n5
              n1->n2
              n2->n1
        root->n2->n4->n5
                  n4->n3
         */
        Node<Integer> root = new Node<>(9);
        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(8);
        Node<Integer> n3 = new Node<>(6);
        Node<Integer> n4 = new Node<>(5);
        Node<Integer> n5 = new Node<>(1);
        root.addNeighbours(List.of(n1, n2));
        n1.addNeighbours(List.of(n2, n3));
        n2.addNeighbours(List.of(n1, n4));
        n3.addNeighbours(List.of(n5));
        n4.addNeighbours(List.of(n3, n5));

        System.out.println(bfs(root.value(), root));
        System.out.println(bfs(n1.value(), root));
        System.out.println(bfs(n2.value(), root));
        System.out.println(bfs(n3.value(), root));
        System.out.println(bfs(n4.value(), root));
        System.out.println(bfs(n5.value(), root));
        System.out.println(bfs(null, root));
        System.out.println(bfs(0, root));
        System.out.println(bfs(100, root));
    }

    static <T> boolean bfs(T value, Node<T> root) {
        if (value == null || root == null) {
            return false;
        }

        HashSet<Node<T>> visitedNodes = new HashSet<>();
        ArrayDeque<Node<T>> visitingNodesQueue = new ArrayDeque<>();
        visitingNodesQueue.addLast(root);

        while (!visitingNodesQueue.isEmpty()) {
            Node<T> curr = visitingNodesQueue.pollFirst();
            if (!(curr == null || visitedNodes.contains(curr))) {
                if (value.equals(curr.value())) {
                    return true;
                }
                visitedNodes.add(curr);
                curr.neighbours().stream().filter(n -> !visitedNodes.contains(n)).forEach(visitingNodesQueue::addLast);
            }
        }

        return false;
    }

    static class Node<E> {
        private final E value;
        private final List<Node<E>> neighbours = new ArrayList<>();

        public Node(E value) {
            if (value == null) {
                throw new IllegalArgumentException("Node field 'value' cannot be null!");
            }
            this.value = value;
        }

        public E value() {
            return value;
        }

        public List<Node<E>> neighbours() {
            return neighbours;
        }

        public void addNeighbours(List<Node<E>> nodes) {
            if (nodes != null) {
                neighbours.addAll(nodes);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "Node [value=" + value + ']';
        }
    }
}
