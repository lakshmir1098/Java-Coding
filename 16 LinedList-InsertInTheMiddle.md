## Question:
Given the head of a Singly Linked List and a value x. The task is to insert the key in the middle of the linked list.

## Examples:

Input: LinkedList = 1->2->4 , x = 3
Output: 1->2->3->4
Explanation: 
The new element is inserted after the current middle element in the linked list.

Input: LinkedList = 10->20->40->50 , x = 30
Output: 10->20->30->40->50
Explanation: 
The new element is inserted after the current middle element in the linked list and Hence, the output is 10->20->30->40->50.

## Solution:
```java
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


class Solution {
    public Node insertInMiddle(Node head, int x) {
        // Code here
        if ( head == null)  return new Node(x);
     
        Node newNode = new Node(x);
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        newNode.next = slow.next;
        slow.next = newNode;
    
        return head;
        
        
        
    }
}
```

```java

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


class Solution {
    public Node insertInMiddle(Node head, int x) {
        // Code here
        if ( head == null)  return new Node(x);
        Node slow = head;
        Node fast = head;
        Node prev = null;
        Node newn = new Node(x);
        
        while( fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast =  fast.next.next;
        }
        
        //odd number of elements
        if( fast != null){
            newn.next = slow.next;
            slow.next = newn;
        }
        // even number of elemnets
        else{
            newn.next = prev.next;
            prev.next = newn;
        }
        
        return head;
        
        
        
    }
}
```