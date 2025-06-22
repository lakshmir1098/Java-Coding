## Question:
Given the head of a Singly Linked List and a number k, the task is to find the data of the modular node of the linked list. If no such index is present return -1.
A modular node is defined as the last node in the linked list whose index is divisible by k (i%k==0). 
Note: 1-based indexing is followed

## Examples :
Input: LinkedList: 1->2->3->4->5->6->7 , k = 3
Output: 6
Explanation: Indexing of the linked list is same as the values of the Node. The maximum index which is divisble by 3 is 6 and the
node value of the 6th index is 6.

Input: LinkedList: 19->28->37->46->55 , k = 13
Output: -1
Explanation: Index start from 1 and end at 5. There is no index which can divisible by 13, so output is -1.

## Solution:
```java
class Node {
    int data;
     Node next;
     Node(int key)
     {
         data = key;
         next = null;
     }
}

class Solution {
    public int modularNode(Node head, int k) {

       if( head == null || k <= 0)  return -1;
       int count = 1;
       int result =  -1;

        while( head != null){
           if(count % k == 0){
               result =  head.data;
           }
           count++;
           head = head.next;
        }
         
        return result;
       
    }
}
```