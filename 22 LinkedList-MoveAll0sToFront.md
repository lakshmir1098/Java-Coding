## question:
Given a linked list, the task is to move all 0s to the front of the linked list. The order of all other elements except 0 should be the same after rearrangement.

## Examples:

Input:  0 -> 4 -> 0 -> 5 -> 0
Output: 0 -> 0 -> 0 -> 4 -> 5
Explanation: After moving all 0s of the given list to the front, the list is: 0 -> 0 -> 0 -> 4 -> 5

## Solution:
```java
public static Node moveZeroes(Node head) {
        // Your Code here.
        Node pre = null;
        Node cur = head;
        if(head==null || head.next==null) return head;

        while( cur != null){
            if(cur.data == 0 && cur!= head){
                pre.next = cur.next;
                cur.next = head;
                head = cur;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
```