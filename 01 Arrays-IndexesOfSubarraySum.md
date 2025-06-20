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
  2. keep in mind that ` l < r ` and `r < n`
  3. Total sum to achieve is S which lets say 12 as in example1  `s = 12` and take `currSum = 0` to sum up each element upon iteration.
  4. Now `l` and `r` are in same index and points to element 0. the `currSum =arr[r]` which is not equal to 12.
  5. So, we move `r` to next index. Now `r` has `2` and put `2` into `currSum` and check of it **equal** to `s`. No its not 
  cause, **`1+2 = 3`** is still not equal to `12`.
  6. We repeat this until `12` is obtained with `l` being in `index 0` as of now.
  7. With `l` in index `0` if the **`currSum = s` is not obtained** or **`currSum` becomes greated then `s`**. We move `l` to index `1`

  >## NOTE
  >
  > Since the output require both the `l` and `r` index or `-1` in case of no match. Its dynamic and can't use normal array. We have to use `ArrayList` to add the index as result and print the ArrayList
  >
  > We can also use `while loop`



## Solution

```java
public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // code here
        ArrayList<Integer> al  =  new ArrayList<>();
        int l = 0;
        int currSum =0;
        
        for (int r = 0 ; r < n ; r ++){
            currSum += arr[r]; 
            while (currSum > s && l < r){
                // since it become greater we have to start removing element
                // so which one, obviously the 1st one i.e arr[l] and move the l to 
                // next index.
                // why l because we kept it as source of truth while r moves all along again
                // this is called sliding window technique
                currSum -= arr[l];
                l++;
            }
               
            if(currSum == s) {
                al.add(l+1);
                al.add(r+1);
                return al;
            }
        }
        al.add(-1);
        return al;
    }
```



