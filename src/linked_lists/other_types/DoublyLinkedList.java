package linked_lists.other_types;

/**
 * Problem Solving in Data Structures Algorithms using Java
 * @author Hemant Jain
 */

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int v, Node nxt, Node prv) {
            value = v;
            next = nxt;
            prev = prv;
        }
    }
    /* Other methods */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        return head.value;
    }

    public void addHead(int value) {
        Node newNode = new Node(value, null, null);
        // TODO 1: Complete the method below this comment.

        // Test if list is empty
        if (size ==0) {
            head = newNode;
            tail = newNode;

        }
        // Otherwise, update the nodes
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        // Increase the size
        size ++;

    }

    public void addTail(int value) {
        Node newNode = new Node(value, null, null);
        // TODO 2: Complete the method below this comment.

    }

    /**
     * Removes the nth node from the end list.
     * @param n index of the node
     * @return whether the operation was successful
     */
    public boolean removeNthNode(int n) {

        Node current = tail;
        int distanceTraversed = 1;

        while (current != null) {
            if (distanceTraversed == n) {
                // remove
                Node a = current.prev;
                Node b = current;
                Node c = current.next;
                a.next = c;
                c.prev = a;

                size --;
                return true;

            }

            current = current.prev;
            distanceTraversed ++;
        }


        return false;
    }

    public int removeHead() {
        if (isEmpty())
            throw new IllegalStateException("EmptyListException");
        int value = head.value;
        head = head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;

        size--;
        return value;
    }

    public boolean removeNode(int key) {
        Node curr = head;
        if (curr == null) // empty list
            return false;

        if (curr.value == key)// head is the node with value key.
        {
            head = head.next;
            size--;
            if (head != null)
                head.prev = null;
            else
                tail = null; // only one element in list.
            return true;
        }

        while (curr.next != null) {
            if (curr.next.value == key) {
                curr.next = curr.next.next;
                if (curr.next == null) // last element case.
                    tail = curr;
                else
                    curr.next.prev = curr;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void deleteList() {
        head = null;
        tail = null;
        size = 0;
    }



    // Sorted insert increasing
    public void sortedInsert(int value) {
        Node temp = new Node(value, null, null);

        Node curr = head;
        if (curr == null)// first element
        {
            head = temp;
            tail = temp;
            return;
        }

        if (head.value > value)// at the beginning
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
            return;
        }

        while (curr.next != null && curr.next.value < value)// traversal
        {
            curr = curr.next;
        }

        if (curr.next == null)// at the end
        {
            tail = temp;
            temp.prev = curr;
            curr.next = temp;
        } else /// all other
        {
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            temp.next.prev = temp;
        }
    }

    /*
     * Reverse a doubly linked List iteratively
     */

    public void reverseList() {
        Node curr = head;
        Node tempNode;
        while (curr != null) {
            tempNode = curr.next;
            curr.next = curr.prev;
            curr.prev = tempNode;

            if (curr.prev == null) {
                tail = head;
                head = curr;
                return;
            }

            curr = curr.prev;
        }
        return;
    }

    public void removeDuplicate() {
        Node curr = head;
        while (curr != null) {
            if ((curr.next != null) && curr.value == curr.next.value) {
                curr.next = curr.next.next;
                if(curr.next != null)
                    curr.next.prev = curr;
                else
                    tail = curr;
            } else {
                curr = curr.next;
            }
        }
    }

    public DoublyLinkedList copyListReversed() {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node curr = head;

        while (curr != null) {
            dll.addHead(curr.value);
            curr = curr.next;
        }
        return dll;
    }

    public DoublyLinkedList copyList() {
        DoublyLinkedList dll = new DoublyLinkedList();
        Node curr = head;

        while (curr != null) {
            dll.addTail(curr.value);
            curr = curr.next;
        }
        return dll;
    }

    // Testing code.
    public static void main1() {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        System.out.println("size : " + ll.size());
        System.out.println("isEmpty : " + ll.isEmpty());

        ll.removeHead();
        ll.print();
        System.out.println(ll.search(2));
    }

	/*
    3 2 1
    size : 3
    isEmpty : false
    2 1
    true
	*/

    public static void main2() {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.sortedInsert(1);
        ll.sortedInsert(2);
        ll.sortedInsert(3);
        ll.print();
        ll.sortedInsert(1);
        ll.sortedInsert(2);
        ll.sortedInsert(3);
        ll.print();
        ll.removeDuplicate();
        ll.print();
    }

	/*
	1 2 3
	1 1 2 2 3 3
	1 2 3
	*/

    public static void main3() {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();

        DoublyLinkedList l2 = ll.copyList();
        l2.print();
        DoublyLinkedList l3 = ll.copyListReversed();
        l3.print();
    }

	/*
	3 2 1
	3 2 1
	1 2 3
	*/

    public static void main4() {
        DoublyLinkedList ll = new DoublyLinkedList();
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

    public static void main5() {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addHead(1);
        ll.addHead(2);
        ll.addHead(3);
        ll.print();
        ll.reverseList();
        ll.print();
    }

	/*
	3 2 1
	1 2 3
	*/

    public static void main(String[] args) {
        main1();
        main2();
        main3();
        System.out.println("main4: ");
        main4();
        System.out.println("main5: ");
        main5();
    }
}
