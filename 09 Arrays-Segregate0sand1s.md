## Question:
Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

## Examples:
1. Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].
2. Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]

    Expected Time Complexity: O(n)

## Solution Explanation:
 how we use 3 pointer for previous problem. Here we have to use 2 pointers `left` and `right`.

 And we have to iterate both left and right here until `left` < `right`
 
 ## Solution:
 ```java
 class Solution {
    void segregate0and1(int[] arr) {
        // code here
        // using 2 pointers
        int l = 0;
        int r = arr.length - 1;
        
        while(l < r){
            while(arr[l] == 0 && l < r){
                l++;
            }
            while(arr[r] == 1 && l < r){
                r--;
            }
            
            if (l < r){
                arr[l] = 0;
                arr[r] = 1;
                l++;
                r--;
            }
        }
    }
}
 ```

