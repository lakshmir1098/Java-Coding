## Question
Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

## Examples

1. Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
2. Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
3. Input: n = 4, arr[] = {5, 10, 20, 40} 
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
4. Input: n = 4, arr[] = {30, 10, 10, 5} 
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.

## Solution Explanation

1. whenever a question has maximum or greater then you will have a vriable to store `max_value`

The trick here is instead of iterating from 1 to n here we have to interate in reverse order as we are finging right most side from left.

## Solution
```java
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
        int max = arr[n-1];
        al.add(max);
        
        for (int i = n-2 ; i >= 0; i--){
            if(max <= arr[i]){
                max = arr[i];
                al.add(max);
            }
            
        }
        
        Collections.reverse(al);
        
        return al;
    }
}
```