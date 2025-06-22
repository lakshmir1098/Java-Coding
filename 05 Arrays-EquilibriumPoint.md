## Question:
Given an array arr of non-negative numbers. The task is to find the first equilibrium point in an array. The equilibrium point in an array is an index (or position) such that the sum of all elements before that index is the same as the sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

## Examples:
1. Input: arr[] = [1, 3, 5, 2, 2]
Output: 3 
Explanation: The equilibrium point is at position 3 as the sum of elements before it (1+3) = sum of elements after it (2+2). 
2. Input: arr[] = [1]
Output: 1
Explanation: Since there's only one element hence it's only the equilibrium point.
3. Input: n = 3, arr[] = [1, 2, 3]
Output: -1
Explanation: There is no equilibrium point in the given array.

## Solution Explanation:
1. As the question says, `left_sum == right_sum` is something we have to achieve.
2. We are going to sum all elemnets array into `right_sum` and then, on each iteration `minus` from `right_sum` and `add ` into `left_sum` while finding `left_sum == right_sum`.

## Solution:
```java 
    public static long equilibriumPoint(long arr[]) {
        int n = arr.length;
        long lsum = 0; long rsum = Arrays.stream(arr).sum();
        
        for (int i =0 ; i < n; i++){
            rsum -=arr[i];
            if(lsum == rsum){
                return i+1;
            }
            lsum += arr[i];
        }
        
        return -1;
    }

```