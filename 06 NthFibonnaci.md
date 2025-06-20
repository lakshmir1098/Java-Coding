## Question
Given a positive integer N, find the last digit of the Nth term from the Fibonacci series.
Note: For N=0 you have to return 0.
 

## Example:
1. Input:
N = 5
Output:
5
Explanation:
5th Fibonacci number is 5
Example 2:

2. Input:
N = 14
Output:
7
Explanation:
14th Fibonacci number is 377
It's last digit is 7

## Solution Explanation
The Fibonacci sequence starts with:

F(0) = 0

F(1) = 1

F(2) = 0 + 1 = 1

F(3) = 1 + 1 = 2

F(4) = 1 + 2 = 3

And so on...
So, the sequence begins: 0, 1, 1, 2, 3, 5, 8, ...

1. The use of % 10 in the line int `next = (a + b) % 10;` within the loop of your Fibonacci calculates the last digit of each Fibonacci number rather than the entire number itself
2. If you were to apply % 10 only at the end (when returning), you would have the entire Fibonacci number, which could be very large that the Fibonacci numbers can exceed the limits of standard `int`. You can also solve this by using `long` or `BigInteger`.

## Solution
```java
static int fib(int n){
    if (n <= 0) {
        return 0; // No Fibonacci numbers for non-positive n
    }
    
    int a = 0; //F(0) = 0
    int b = 1; //F(1) =  1
    for (int i = 2; i <= n; i++) { //from F(2) until including F(n)
        int next = (a + b)%10;
        a = b;
        b = next;
    }
    return b; // Return the nth Fibonacci number

}
```

or 

```java
static int fib(int n){
    if (n <= 0) {
        return 0; // No Fibonacci numbers for non-positive n
    }
    
    
    BigInteger a = BigInteger.ZERO; //F(0)
    BigInteger b = BigInteger.ONE; //F(1)
    BigInteger ten = BigInteger.TEN;
    
    for (int i = 2; i <= n; i++) { //from F(2) until including F(n)
        BigInteger next = a.add( b);
        a = b;
        b = next;
    }
    return b.mod(ten).intValue(); // Return the nth Fibonacci number

}
```

or 
```java
static long fib(int n){
        if (n <= 0) {
            return 0; // No Fibonacci numbers for non-positive n
        }
        
        long a = 0; //F(0) = 0
        long b = 1; //F(1) =  1
        for (int i = 2; i <= n; i++) { //from F(2) until including F(n)
            long next = (a + b);
            a = b;
            b = next;
        }
        return b%10; // Return the nth Fibonacci number
    
    }
```
