## Question:
  
  Given an unsorted array arr of size n that contains only non negative integers, find a sub-array (continuous elements) that has sum equal to s. You mainly need to return the left and right indexes(1-based indexing) of that subarray.

## Examples:

  1. Input: arr[] = [1,2,3,7,5], n = 5, s = 12
  Output: 2 4
  The sum of elements from 2nd to 4th position is 12.

  2. Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15
  Output: 1 5
  Explanation: The sum of elements from 1st to 5th position is 15.

  3. Input: arr[] = [7,2,1], n = 3, s = 2
  Output: 2 2
  Explanation: The sum of elements from 2nd to 2nd position is 2.

  4. Input: arr[] = [5,3,4], n = 3, s = 2 
  Output: -1
  Explanation: There is no subarray with sum 2


## Solution Explanation:
  1. Take the left and right indexed l and r both equal to 0  `l = 0; r = 0;`
  2. Total sum to achieve is S which lets say 12 as in example1  `s = 12` and take `currSum = 0` to sum up each element upon iteration.
  3. Now `l` and `r` are in same index and points to element 1 which is not equal to 12.
  4. So, we move `r` to next index. Nor `r` has `2` and put `2` into `currSum` and check of it **equal** to `s`. No its not 
  cause, **`1+2 = 3`** is still not equal to `12`.
  5. We repeat this until `12` is obtained with `l` being in `index 0` as of now.
  6. With `l` in index `0` if the **`currSum = s` is not obtained** or **`currSum` becomes greated then `s`**. We move `l` to `index 1`

## Solution

```



