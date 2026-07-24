# Binary Exponentiation

## When to use
- Compute a^b where b is very large.
- Modular exponentiation.
- Matrix exponentiation.
- Fast Fibonacci.

## Idea
If n is even:
a^n = (a^(n/2))²

If n is odd:
a^n = (a^(n/2))² × a

## Complexity
Time: O(log n)
Space:
- Recursive: O(log n)
- Iterative: O(1)

## Problems
- LeetCode 50 - Pow(x, n)
- LeetCode 1922 - Count Good Numbers