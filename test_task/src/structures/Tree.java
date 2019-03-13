package structures;

import structures.impl.Node;

import java.util.Collection;

/**
 * structures.Tree that contains no duplicate elements.
 *
 * @author Maria_Dron
 */
public interface Tree<E> {
    boolean addAll(Collection<E> c);
    void addNode(E value);
    void removeNode(E value);
    Node<E> findParent(Node<E> node);
    Node<E> search(E value);
    boolean contains(E value);
    int getDepth(Node<E> node);
    Node<E> root();
    boolean isEmpty();
    int size();
}
