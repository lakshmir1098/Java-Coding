## Question:
Given the head of a Singly Linked List and an index, The task is to find the node at the given index(1-based index) of the linked list. If no such index exists then return -1.

## Examples:

Input: LinkedList: 1->2->3->4->5->6->7 , index = 3
Output: 3
Explanation: The Node value at index 3 is 3.

Input: LinkedList: 19->28->37->46->55 , index = 6
Output: -1
Explanation: As number of nodes are less than k so there is no node at index 6 , therefore our answer is -1.

## Solution:
```java
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class Solution {
    public int GetNth(Node head, int index) {
        // Code here
        int i = 0;
        Node current = head;
        if (head == null) return -1;
        while ( current != null ){
            if( i == index-1){
                return  current.data;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
}
```
