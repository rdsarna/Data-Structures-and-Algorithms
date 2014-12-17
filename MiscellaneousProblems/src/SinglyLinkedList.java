/**
 * The basic Singly Linked List implementation that supports
 * the following operations:
 * a) Reverse the linked list.
 * b) Reverse the linked list in groups of given size.
 *
 */
public class SinglyLinkedList {

    private static class Node {
        int value;
        Node next;
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void push(int value) {
        Node newOne = new Node();
        newOne.value = value;
        newOne.next = head;
        head = newOne;
        size += 1;
    }

    public int pop() {
        if (head == null)
            throw new NullPointerException();

        int returnValue = head.value;
        head = head.next;
        size -= 1;
        return returnValue;
    }

    public int size() {
        return size;
    }

    public void reverseRec() {
        reverse(this.head);
    }

    private void reverse(Node node) {
        /* Case where the list is empty or only has one item */
        if (node == null || node.next == null)
            return;

        /* Base case */
        if (node.next.next == null) {
            node.next.next = node;
            this.head = node.next;
            return;
        }

        /* Recursive call with next node as the head */
        reverse(node.next);

        node.next.next = node;
        node.next = null;
    }

    public void reverseIterative() {
        Node prev = null;
        Node next = null;
        Node curr = this.head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        this.head = prev;
    }

    /** Reverses the linked list in groups of size k */
    public void reverse(int k) {
        reverse(this.head, k);
    }

    private void reverse(Node head, int k) {
        Node next = null;
        Node curr = head;
        Node prev = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count += 1;
        }

        if (next != null) {
            reverse(next, k);
            head.next = this.head;
        }

        this.head = prev;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (Node curr = head; curr != null; curr = curr.next) {
            returnString.append(curr.value);
            returnString.append(", ");
        }
        returnString.delete(returnString.length()-2, returnString.length());
        return returnString.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push(0);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);

        System.out.println(list);

        list.reverse(3);

        System.out.println(list);
    }

}
