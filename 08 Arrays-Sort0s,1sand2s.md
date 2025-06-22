## Question:
Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.

## Examples:

1. Input: arr[] = [0, 2, 1, 2, 0]
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated into ascending order.
2. Input: arr[] = [0, 1, 0]
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated into ascending order.

Expected Time Complexity: O(n)

## Solution Explanation:
1. You may think this is simple sorting. Yes `Arrays.sort()` will ofcourse give you the result. But this has the time complexity of `O(nlogn) ` which is greater than expected `O(n)`.
2. So, there are 2 more ways to solve this. Let see the 2<sup>nd</sup> way of doing this.
    
    a. count the no. of 0's, 1's, and 2's into `c0`, `c1`, `c2`.
    
    b. Then until count of c0 times add 0 , then until c1 time from c0 add 1 and so for 2.

This involves traversing through the array twice (which increase time complexity) and can be used only for numbers problem.

Lets say, you have problem where you have to sort by red ball 10 and blue ball 10. In this case, the above will sort on number 10 but may or may not sort on color red and blue. So this is **`unstable`** method when coming to anything other than number sorting of same numbers.

3. So the last methid is call **`Dutch National Flag Algorithm`**. This is usally helpful for sorting 3 things. For instance, here 0,1,2 or red,blue,green like that.
    
    The algorithm uses 3 bounds/ index pointers `low`, `mid` and `high`. For our example,
    Goal here is after sorting all elements
    > from `0` to `low-1` = 0
    >
    >  `low` to `mid` = 1
    >
    > `high-1` to `n` = 2

    We only iterate  `mid` pointer keeping `low` and `high` only `increament` and `decrement` resp.


## Solution:
```java
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // using dutch national flag algorithm
        int low = 0;
        int mid =0;
        int high = arr.length -1;
        int temp = 0;
        
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }
            else if(arr[mid] == 1 ){
                mid++;
            }
            else{
                swap(arr, mid,high);
                high --;
            }
        }
    }
```
    



