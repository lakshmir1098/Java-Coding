## Question:
Given an array arr of size N and an element k. The task is to find the count of elements in the array that appear more than n/k times.

## Examples:

1. Input:
N = 8
arr = [3,1,2,2,1,2,3,3]
k = 4
Output: 
2
Explanation: 
In the given array, 3 and 2 are the only elements that appears more than n/k times.
Example 2:

2. Input:
N = 4
arr = [2,3,3,2]
k = 3
Output: 
2
Explanation: In the given array, 3 and 2 are the only elements that appears more than n/k times. So the count of elements are 2.

Your Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

## Solution Explanation:
Whenver you see duplicates, remeber Hash and since you want cound and not remove them So we use `hashMap` here.

## Solution:
```java
class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        HashMap<Integer, Integer> hm  =  new HashMap<>();
        int nByk =  n/k;
        int count = 0;
        
        for(int i =0 ;  i < n; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        
        for (Map.Entry<Integer, Integer> i : hm.entrySet()){
            if(i.getValue() >  nByk){
                count ++;
            }
        }
        
        return count;
    }
}
```
