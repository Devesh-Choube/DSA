# Intuition

The key observation is that we cannot use any extra data structure except recursion.

The solution is divided into two recursive functions:

1. **sortStack()**
    - Removes one element from the top.
    - Recursively sorts the remaining stack.
    - Inserts the removed element back into its correct position.

2. **insert()**
    - Assumes the given stack is already sorted.
    - If the current element belongs on top, push it.
    - Otherwise, pop the top element, recursively insert the current element,
      and restore the popped element.

## Recursive Invariant

When `insert(stack, x)` is called, the stack is already sorted in descending order.
The function inserts `x` while preserving that order.

## Complexity

- Time: O(N²)
- Space: O(N) (recursive call stack)