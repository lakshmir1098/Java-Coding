## Question:
Given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList and return the modified Linked List.

## Examples:
Input: LinkedList: 1->2->3->4->5 , x = 6

Output: 1->2->3->4->5->6

## Solution Explanation:
We don`t have length and have only head known. SO we have to traverse until curr.next = null (whicg is tail) and then make curr.next = new node. Then return head to return the linked list.

## Solution:
```java
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node insertNode = new Node (x);
        
        if (head == null)  return insertNode;
       
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = insertNode;
        return head;
        
    }
}
```