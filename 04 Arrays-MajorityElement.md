## Question
Given an array arr. Find the majority element in the array. If no majority exists, return -1.

A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

## Examples:

1. Input: arr[] = [3, 1, 3, 3, 2]
Output: 3
Explanation: Since, 3 is present more than n/2 times, so it is the majority element.
2. Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than n/2 times, so it is the majority element.
3. Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than n/2 times, so there is no majority element.

## Solution Explanation
1. Like how we use `HashSet` to find duplicates, Use `HashMap` to count the no. of time elements is repeated.
2. In `HashMap` we use  `hm.getOrDefault(arr[i], 0)` when you want to retrieve the current count and `hm.getOrDefault(arr[i], 0) + 1` when you want to increment that count.
3. `hm.put(arr[i], count + 1)` to update the count.
4. As per this question to find majority element, the element should be repeated more then half the lenght of the array.

## Solution
```java
static int majorityElement(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        for ( int i =0; i<n ;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> it : hm.entrySet()){
            if(it.getValue() > n/2){
                return it.getKey();
            }
        }
        return -1;
    }
```