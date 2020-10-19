// https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
package gfg;

/* Node of a linked list */
class Node {
    public int data;
    public Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedListMiddle {

    public int getMiddle(Node head) {

        if (head.next == null) {
            return head.data;
        }

        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        curr = head;
        int middle = count / 2;
        int currCount = 0;
        while (curr != null) {
            if (currCount == middle) {
                break;
            }
            currCount++;
            curr = curr.next;
        }
        return curr.data;
    }

    public int getMiddleOnePass(Node head) {
        Node ptr1 = head;
        Node ptr2 = head;

        if (head.next == null) {
            return head.data;
        }

        while (ptr2 != null && ptr2.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;

        }

        return ptr1.data;
    }
}
