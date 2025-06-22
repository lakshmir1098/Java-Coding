## Question:
Given an array arr of positive integers. Reverse every sub-array group of size k.

Note: If at any instance, k is greater or equal to the array size, then reverse the entire array. You shouldn't return any array, modify the given array in place.

## Examples:
1. Input: k = 3, arr= [1, 2, 3, 4, 5]
Output: [3, 2, 1, 5, 4]
Explanation: First group consists of elements 1, 2, 3. Second group consists of 4,5.
2. Input: k = 5, arr = [5, 6, 8, 9]
Output: [9, 8, 6, 5]
Explnation: Since k is greater than array size, the entire array is reversed.

## Solution Explanation:
1. First find if k < n,
    1. for each iteration you have to find the `left` and `right` bound to reverse.
    2. While `left` = `i`
              `right` = `i+k-1`

    3. But this calculation for `right` can exceed `n - the lenght/size of an givn array`
    4. So instead of just `right` = `i+k-1` we find min between `i+k-1` ad `n-1`. `right =  Math.min ( i+k-1 , n-1)`
    5. for `left` and `right`  boundarie we swap elements to reverse the subarray or use default method.
2. if k >= n, reverse whole array.

## Solution:

```java
class Solution {

    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Long> arr, int k){
        int n = arr.size();
        
        if(k >= n){
            Collections.reverse(arr);
        }
        else{
            for (int i = 0 ; i < n; i +=k){
                int l = i;
                int r =  Math.min ( i+k-1 , n-1);
                
                while( l < r){
                    Collections.swap(arr,l,r);
                    l++;
                    r--;
                }
            }
        }
    }
}
```