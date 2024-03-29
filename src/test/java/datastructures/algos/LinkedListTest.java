package datastructures.algos;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java Source LinkedListTest.java created on Jun 3, 2021
 *
 * @author : Sanjeev Saxena
 * @version : 1.0
 * @email : sanrocks123@gmail.com
 */

public class LinkedListTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private class Node {
        private final int data;
        private final Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void printReverseList(Node node) {

            if (node == null)
                return;
            else
                printReverseList(node.next);
            log.info("[{}]", node.data);
            System.out.print(node.data);
        }

    }

    @Test
    public void testReverseList() {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        head.printReverseList(head);
    }

    @Test
    public void testListOperations(){
        List<String> names = Arrays.asList("a","b","c");
        System.out.println(names);

        names.add(0,"d");

        System.out.print(names);

    }


}
