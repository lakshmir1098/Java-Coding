## Question:
Given the two singly Linked Lists respectively. The task is to check whether two linked lists are identical or not. 
Two Linked Lists are identical when they have the same data and with the same arrangement too. If both Linked Lists are identical then return true otherwise return false. 

## Examples:

Input: LinkedList1: 1->2->3->4->5->6, LinkedList2: 99->59->42->20
Output: false

Input: LinkedList1: 1->2->3->4->5, LinkedList2: 1->2->3->4->5
Output: true

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
   
    public boolean areIdentical(Node head1, Node head2) {
        while ( head1 != null && head2 != null){
            if(head1.data != head2.data){
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return  head1 == null && head2 == null;
    }
}
```