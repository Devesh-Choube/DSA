# Reverse a Stack

## Problem
Given a stack of integers, reverse the stack using **recursion**.

### Constraints
- Only standard stack operations are allowed:
    - `push()`
    - `pop()`
    - `peek()/top()`
    - `isEmpty()`
- No loops for the reversal logic.
- No extra data structures (arrays, queues, another stack, etc.).
- Reverse the stack in-place.

---

## Intuition

A stack only allows access to the top element, so we cannot directly place an element at the bottom.

The idea is to use recursion in two phases:

1. Recursively remove all elements from the stack until only one remains.
2. While the recursive calls return, insert each removed element at the **bottom** of the stack.

Since every popped element is inserted at the bottom, the order of the stack gets reversed.

---

## Approach

### Step 1: Reverse the remaining stack
- Pop the top element.
- Recursively reverse the rest of the stack.
- Insert the popped element at the bottom.

### Step 2: Insert an element at the bottom
To insert an element at the bottom:
- If the stack is empty, push the element.
- Otherwise:
    - Pop the top element.
    - Recursively insert the new element.
    - Push the removed element back.

---

## Dry Run

Initial Stack (Top → Bottom)

```
5
4
3
2
1
```

Pop recursively:

```
Pop 5
Pop 4
Pop 3
Pop 2
Remain: 1
```

While returning:

```
Insert 2 at bottom
2 1

Insert 3 at bottom
3 2 1

Insert 4 at bottom
4 3 2 1

Insert 5 at bottom
5 4 3 2 1
```

Final Stack (Top → Bottom)

```
1
2
3
4
5
```

---

## Complexity Analysis

**Time Complexity:** `O(N²)`

- Reversing makes `N` recursive calls.
- Each insertion at the bottom may take up to `O(N)` time.

Overall:

```
O(N) × O(N) = O(N²)
```

**Space Complexity:** `O(N)`

- Due to the recursion call stack.

---

## Key Learning

- Recursion can simulate backtracking.
- A helper function can modify the bottom of a stack without using any extra data structure.
- Complex stack operations can often be built using only `push()`, `pop()`, and recursion.

---

## Related Problems

- Sort a Stack
- Delete Middle Element of a Stack
- Insert an Element at the Bottom of a Stack
- Reverse a Stack using Recursion