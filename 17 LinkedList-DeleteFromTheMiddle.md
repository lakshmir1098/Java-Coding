## Question:
Given a singly linked list, delete the middle of the linked list.

Note:

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
If the input linked list has a single node, then it should return NULL.

## Examples:

Input: LinkedList: 1->2->3->4->5
Output: 1->2->4->5

## Solution:
```java
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

class Solution {
    Node deleteMid(Node head) {
        Node prev = null;
        Node slow = head;
        Node fast = head;
        
         if(head==null||head.next==null)   return null;
        
        
        while( fast != null && fast.next != null ){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;
        
        return head;
    }
}
```