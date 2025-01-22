package linked_lists.other_types;

import linked_lists.instance_variables.ListNode;

//synchronization for vectors
// list methods
// list interface and eveything it implemetns

public class ListLabs5 {
    public static void main(String[] args) {

        // Problem 1
        DoublyLinkedList list = new DoublyLinkedList();
        list.addHead(5);
        list.addHead(2);
        list.addHead(7);
        list.addHead(-3);
        list.addHead(17);
        list.addHead(62);
        list.addHead(109);
        list.addHead(1);
        list.print();

        boolean success = list.removeNthNode(5);
        System.out.printf("Expected: true Size: 7 List: %s\nActual:   %b Size: %d List: ",
                "1 109 62 -3 7 2 5 ", success, list.size());
        list.print();


        // Problem 2
        ListNode head = new ListNode(8, null);
        head = new ListNode(56, head);
        head = new ListNode(7, head);
        head = new ListNode(-9, head);
        head = new ListNode(22, head);

        System.out.printf("Expected: false\nActual:   %b\n" +
                "", isCircular(head));

        ListNode head2 = new ListNode(-16, null);
        ListNode first = head2;
        head2 = new ListNode(3, head2);
        head2 = new ListNode(-25, head2);
        head2 = new ListNode(7, head2);
        head2 = new ListNode(4, head2);
        first.setNext(head2);

        System.out.printf("Expected: true\nActual:   %b", isCircular(head2));
    }

    /**
     * Determines if a singly linked list is circular.
     * @param head the head of the list
     * @return whether the list is circular
     */
    public static boolean isCircular(ListNode head) {

        // loop around until u get to the other side or reach the same thing again
        ListNode current = head.getNext();
        while (current != null) {
            if (current == head) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}
