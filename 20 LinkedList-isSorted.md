## Question:
Given a linked list of size n, you have to find whether the given linked list is sorted or not.
The sorting can either be non-increasing or non-decreasing.

## Examples:

Input:
LinkedList: 5->5->6->7->8
Output: 1


Input:
LinkedList: 2->5->7->8->99->7
Output: 0

Your Task:
The task is to complete the function isSorted() which takes head reference as argument. The function returns true if the LL is sorted, else it returns false. (The driver code prints 1 when the returned value is true, otherwise 0)

NOTE: its should be tested that it can be sorted in both increasing or decreasing order

## Solution:
```java
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}


class Solution {
    public static boolean isSorted(Node head) {
        Node slow = head;
        Node fast = head.next;
        int inc = 0; int dec = 0;
        while(fast != null){
            if(slow.data <= fast.data){
                inc = inc;
            }
            else {
                inc ++;
            }
            if (slow.data >= fast.data){
               dec = dec;
            }
            else{
                dec++;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if ( inc == 0 || dec == 0) return true;
        else return false;
    }
}
```