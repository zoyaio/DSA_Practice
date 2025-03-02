package linked_lists.other_types;

/**
 * Problem Solving in Data Structures Algorithms using Java
 * @author Hemant Jain
 */

public class CircularLinkedList {
    private Node tail = null;
    private int size = 0;

    private static class Node {
        private int value;
        private Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return tail.next.value;
    }
    /* Other methods */


    public void addTail(int value) {
        Node temp = new Node(value, null);
        if (isEmpty()) {
            tail = temp;
            temp.next = temp;
        } else {
            temp.next = tail.next;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void addHead(int value) {
        Node temp = new Node(value, null);
        if (isEmpty()) {
            tail = temp;
            temp.next = temp;
        } else {
            temp.next = tail.next;
            tail.next = temp;
        }
        size++;
    }

    public int removeHead() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("EmptyListException");
        }

        // TODO 3: Complete the method below this comment.
        // Store the value to the node after the tail
        Node head = tail.next;
        // Test if there is only one node (tail is the head)
        if (tail == head) {
            tail = null;

        }
        // Otherwise, set the head to the node after the head (two nodes after the tail)
        else {
            tail.next = head.next;
        }
        // Decrease the size
        size --;
        // Return the value
        return head.value;
    }

    public boolean removeNode(int key) {
        if (isEmpty()) {
            return false;
        }
        Node prev = tail;
        Node curr = tail.next;
        Node head = tail.next;

        if (curr.value == key)// head and single node case.
        {
            if (curr == curr.next)// single node case
                tail = null;
            else // head case
                tail.next = tail.next.next;
            return true;
        }

        prev = curr;
        curr = curr.next;

        while (curr != head) {
            if (curr.value == key) {
                if (curr == tail)
                    tail = prev;
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public CircularLinkedList copyListReversed() {
        CircularLinkedList cl = new CircularLinkedList();
        if (tail == null) {
            return cl;
        }
        Node curr = tail.next;
        Node head = curr;

        if (curr != null) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        while (curr != head) {
            cl.addHead(curr.value);
            curr = curr.next;
        }
        return cl;
    }

    public CircularLinkedList copyList() {
        CircularLinkedList cl = new CircularLinkedList();
        if (tail == null) {
            return cl;
        }
        Node curr = tail.next;
        Node head = curr;

        if (curr != null) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        while (curr != head) {
            cl.addTail(curr.value);
            curr = curr.next;
        }
        return cl;
    }

    public boolean search(int data) {
        Node temp = tail;
        for (int i = 0; i < size; i++) {
            if (temp.value == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void deleteList() {
        tail = null;
        size = 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty List.");
            return;
        }
        Node temp = tail.next;
        while (temp != tail) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }

    public static void main1() {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        System.out.println(ll.size());
        System.out.println(ll.isEmpty());
        System.out.println(ll.peek());
        System.out.println(ll.search(3));
    }

    /*
    3 2 1
    3
    false
    3
    true
    */

    public static void main2() {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addTail(1);
        ll.addTail(2);
        ll.addTail(3);
        ll.print();
    }

    /*
    1 2 3
    */

    public static void main3() {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        ll.removeHead();
        ll.print();
        ll.removeNode(2);
        ll.print();
        ll.deleteList();
        ll.print();
    }

    /*
    3 2 1
    2 1
    1
    Empty List.
    */

    public static void main4() {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        CircularLinkedList ll2 = ll.copyList();
        ll2.print();
        CircularLinkedList ll3 = ll.copyListReversed();
        ll3.print();
    }

    /*
    3 2 1
    3 2 1
    1 2 3
    */

    public static void main5() {
        CircularLinkedList ll = new CircularLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        ll.removeNode(2);
        ll.print();
    }

    /*
    3 2 1
    3 1
    */

    public static void main(String[] args) {
        main1();
        main2();
        main3();
        main4();
        main5();
    }
}