## Question:
Intersection of Two Linked Lists
Difficulty: EasyAccuracy: 35.3%Submissions: 67K+Points: 2Average Time: 15m
Given two linked lists head1 and head2, find the intersection of two linked lists. Each of the two linked lists contains distinct node values.

Note: The order of nodes in this list should be the same as the order in which those particular nodes appear in input head1 and return null if no common element is present.

## Examples:

Input: LinkedList1: 9->6->4->2->3->8 , LinkedList2: 1->2->8->6
 
Output: 6->2->8
Explanation: Nodes 6, 2 and 8 are common in both of the lists and the order will be according to LinkedList1. 

## Solution:
```java
class Node
{
    int data;
    Node next;

    Node(int a)
        {
            data = a;
            next = null;
        }
}

class Solution {
    
    public Node findIntersection(Node head1, Node head2) {
       //ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> al = new HashSet<>();
        while ( head2 != null){
            al.add(head2.data);
            head2 = head2.next;
        }
        
        Node dummy = new Node(0);
        Node intersectedLL = dummy;
        while(head1 != null ){
            if (al.contains(head1.data)){
                intersectedLL.next = new Node (head1.data);
                intersectedLL = intersectedLL.next;
                
            }
            
            head1 = head1.next;
           
        }
        
        // Used ArrayList but its time cpmplexity is O(n*m)
        // Use HashSet for timecomplexity of O(n+m)
        
        return dummy.next;
    }
}
```