package structures.impl;

import structures.Tree;

import java.util.Collection;

/**
 * Binary structures.Tree implementation.
 *
 * @author Maria_Dron
 */
public class BinaryTree<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root = null;
    private int size = 0;

    public BinaryTree() {}

    public BinaryTree(Collection<E> collection) {
        addAll(collection);
    }

    @Override
    public boolean addAll(Collection<E> c) {
        if (c != null && c.size() != 0) {
            c.forEach(this::addNode);
            return true;
        }
        return false;
    }

    @Override
    public void addNode(E value) {
        if (size == 0) {
            root = new Node<>(value);
            size++;
            return;
        }
        if (!contains(value)) {
            addNode(root, value);
        }
    }

    private Node<E> addNode(Node<E> rootNode, E value) {
        if (rootNode == null) {
            return null;
        }
        Node<E> newNode = new Node<>(value);
        if ((newNode.getData()).compareTo(rootNode.getData()) <= 0) {
            if (rootNode.getLeft() != null) {
                rootNode.setLeft(addNode(rootNode.getLeft(), value));
            } else {
                rootNode.setLeft(newNode);
            }
        } else {
            if (rootNode.getRight() != null) {
                rootNode.setRight(addNode(rootNode.getRight(), value));
            } else {
                rootNode.setRight(newNode);
            }
        }
        size++;
        return rootNode;
    }

    @Override
    public void removeNode(E value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node<E> findParent(Node<E> node) {
        return findParent(node.getData(), root, null);
    }

    private Node<E> findParent(E data, Node<E> root, Node<E> parent) {
        if (root == null) {
            return null;
        }
        if ((root.getData()).compareTo(data) != 0) {
            parent = findParent(data, root.getLeft(), root);
            if (parent == null) {
                parent = findParent(data, root.getRight(), root);
            }
        }
        return parent;
    }

    @Override
    public Node<E> search(E value) {
        Node<E> node = root;
        while (node != null && node.getData() != value) {
            if (value.compareTo(node.getData()) <= 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    @Override
    public boolean contains(E value) {
        return search(value) != null;
    }

    @Override
    public int getDepth(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int parent = getDepth(findParent(node));
        return ++parent;
    }

    @Override
    public Node<E> root() {
        return isEmpty() ? null : root;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<E> root) {
        return root == null ? 0 : (size(root.getLeft())) + 1 + (size(root.getRight()));
    }

    public StringBuilder getShortestDistance(Node<E> node) {
        StringBuilder path = new StringBuilder();
        if (node == null) {
            return path;
        }
        path.append(getShortestDistance(findParent(node))).append(node.getData()).append(" ");
        return path;
    }

    public void printPreOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }
}
