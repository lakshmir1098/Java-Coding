## Question:
Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
Note:  Return -1 if you can't reach the end of the array.

## Examples: 

1. Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
Output: 3 
Explanation:First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 
2. Input: arr = [1, 4, 3, 2, 6, 7]
Output: 2 
Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
3. Input: arr = [0, 10, 20]
Output: -1
Explanation: We cannot go anywhere from the 1st element.

## Solution explanation:
For this 3 things are to be kept in mind
a. `max_range` or `jump` - the max number of elements can be jumped from the given index element.
b. `count` or `number_of_jump` - number of jumps taken so far
c. `step` - to check if the `jump` element is reached. Only then count will increase for next jump. So, this happens for each iternation `i` when `step = i`

Overall, `number_of_jump` or how much steps to reah for next step will ne known only when `step = i`

## Solution:
```java
class Solution {
    static int minJumps(int[] arr) {
        // code here
        int jump = arr[0]; //1
        int n = arr.length; //11
        int step =arr[0]; //1
        int count = 1;
        
        if(arr[0] == 0){
            return -1;
        }
        if(arr[0] >= n || n == 1){
            return 1;
        }
        
        
        for(int i=0; i<n; i++){
            jump = Math.max(jump, arr[i]+i);
            if(i==step){
                step =  jump;
                count++;
            }if(step >= n-1){
                return count;
            }
        }
        
        return -1;
     
    }
}
```