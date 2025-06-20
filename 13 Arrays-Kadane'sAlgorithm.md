## Question
Given an integer array arr[]. You need to find and return the maximum sum possible from all the subarrays.

## Examples:

1. Input: arr[] = [1, 2, 3, -2, 5]
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5).
2. Input: arr[] = [-1, -2, -3, -4]
Output: -1
Explanation: Max subarray sum is -1 of element (-1).
3. Input: arr[] = [5, 4, 7]
Output: 16
Explanation: Max subarray sum is 16 of elements (5, 4, 7)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

## Solution Explanation:
The idea of Kadane’s algorithm is to traverse over the array from left to right and for each element, find the maximum sum among all subarrays ending at that element. The result will be the maximum of all these values. 

But, the main issue is how to calculate maximum sum among all the subarrays ending at an element in O(1) time?

To calculate the maximum sum of subarray ending at current element, say maxEnding, we can use the maximum sum ending at the previous element. So for any element, we have two choices:

Choice 1: If the maximum subarray sum ending at the previous index is positive, then it is always better to extend the subarray.
Choice 2: If the maximum subarray sum ending at the previous index is negative, it is always better to start a new subarray from the current element.

This means that maxEnding at index `i = max(maxEnding at index (i – 1) + arr[i], arr[i])` and the maximum value of maxEnding at any index will be our answer. 

## Solution
```java
class Solution {
    int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int max_sum = arr[0];
        
        for ( int i = 1; i<n; i++ ){
            max_sum =  Math.max(max_sum+arr[i], arr[i]);
            res =  Math.max(res, max_sum);
        }
        
        return res;
    }
}

```