## Question:
You are given an integer n and an integer array arr of size n+2. All elements of the array are in the range from 1 to n. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.
Note: Return the numbers in their order of appearing twice. So, if x and y are repeating numbers, and x's second appearance comes before the second appearance of y, then the order should be (x, y).

## Examples:

1. Input: n = 4, arr[] = [1, 2, 1, 3, 4, 3]
Output: 1 3
Explanation: In the given array, 1 and 3 are repeated two times, and as 1's second appearance occurs before 2's second appearance, so the output should be 1 3.
2. Input: n = 2, arr[] = [1, 2, 2, 1]
Output: 2 1
Explanation: In the given array, 1 and 2 are repeated two times and second occurence of 2 comes before 1. So the output is 2 1.

## Solution Explanation:
NOTE: Whenever you want to find a repeated or a element that is already present like duplicate. Always use `HashSet<>`

1. So we are using `HashSet` here. with that if the element in given `arr` contains on the `HashSet` already add it to newly created array `a` or else add it to `HashSet`. By that you can find repeaseted elements

## Solution:
```java
public int[] twoRepeated(int n, int arr[]) {
        int a[] = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        int ai =  0;
        for ( int i = 0; i < n+2 ; i++){
            // n+2 is bevause the question says " integer n and an integer array arr of size n+2"
            if(hs.contains(arr[i])){
                a[ai] =  arr[i];
                ai++;
                
            }
            else{
                hs.add(arr[i]);
            }
        }
        
        
        return a;
    }
```