import structures.impl.BinaryTree;

import java.util.Arrays;
import java.util.List;

/**
 * Main class.
 *
 * @author Maria_Dron
 */
public class Main {
    public static void main(String[] args) {
        List<Character> list = Arrays.asList('d', 'c', 'g', 'e', 'a', 'h', 'f', 'b');
        BinaryTree<Character> binaryTree = new BinaryTree<>(list);
        list.forEach(elem -> System.out.println(String.format("Shortest distance to '%s' node: %s", elem,
                                                              binaryTree.getShortestDistance(binaryTree.search(elem)).toString().trim().replace(" ", " -> "))));
    }
}
