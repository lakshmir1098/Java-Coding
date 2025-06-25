```java
public class LinkedList {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to build a linked list from an array
    public static Node buildLinkedList(int[] values) {
        if (values.length == 0) return null;
        Node head = new  Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new  Node(values[i]);
            current = current.next;
        }

        return head;
    }
    
   
    public static void printList( Node head) {
         Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // Move to next line after printing the list
    }


    // Main method
    public static void main(String[] args) {
        int[] list1 = {0,4,0,5,0};
        Node head1 = buildLinkedList(list1);
        printList(head1);
    }
}
```
