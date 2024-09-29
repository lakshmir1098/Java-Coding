## Question
Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.

## Examples:
1. Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: Minimum length subarray is [4, 45, 6]
2. Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray exist

## Solution Explanation:
1. We have find the smallest subarray here.
2. The issue here is sum should be greater then x but how greater we dont know, unless the no. of elements is less we print that subarray count.
3. Lets take smallest subarray count as `min_len` which is equal to `lenght_of_array + 1`. This is because this value is going to decarease and `min_len` can't go above `lenght_of_array + 1`.
4. Take 2 pointers `start` and `end`.  With `start = 0` we traverse through `end` and sum each end indexes to `currSum`.
5. When `currSum > x` we store into `len = end - start`. NOTE, this is not the smallest subarray. 
6. So we remove `arr[start]` and increament `start` and then again traverse `end` pointer till end to find if there is length lesser than previously found subarray.
7. Here is one more condition, what of there is no value greater than `x` after sum of all the elements. In that case, we have to return `0`.

## Solution
```java
public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int min_len = n+1;
        int len = 0;
        int start = 0, end = 0;
        int curr_sum = 0;
        while (end < n) {
            
            curr_sum += arr[end];
            end ++;
            while (curr_sum > x && start < n) {
                len = end - start;
                if ( len < min_len)
                    min_len = len;
 
                curr_sum -= arr[start];
                start ++;
            }
        }
       if(min_len == n+1){
        return 0;
       }else{
           return min_len;
       }     
        
    }
```