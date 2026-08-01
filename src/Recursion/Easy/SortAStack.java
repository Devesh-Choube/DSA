/*
Problem: Sort a Stack
Platform: TUF
Difficulty: Easy

Approach:
1. Recursively pop all elements until the stack has at most one element.
2. While returning from recursion, insert each popped element into its correct
   position in the already sorted stack.
3. The insert() function temporarily removes larger elements, recursively inserts
   the current element, and then restores the removed elements.

Time Complexity: O(N^2)
- Each insertion may traverse the entire stack.

Space Complexity: O(N)
- Recursive call stack.
*/

import java.util.Stack;

public class SortAStack {

    public void sortStack(Stack<Integer> st) {
        if (st.size() <= 1) {
            return;
        }

        int x = st.pop();

        sortStack(st);

        insert(st, x);
    }

    private void insert(Stack<Integer> st, int x) {

        if (st.isEmpty() || x > st.peek()) {
            st.push(x);
            return;
        }

        int temp = st.pop();

        insert(st, x);

        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);

        System.out.println("Original Stack (Top -> Bottom):");
        printStack(stack);

        SortAStack obj = new SortAStack();
        obj.sortStack(stack);

        System.out.println("\nSorted Stack (Top -> Bottom):");
        printStack(stack);
    }

    private static void printStack(Stack<Integer> stack) {
        // Print from top to bottom without modifying the original stack
        Stack<Integer> temp = (Stack<Integer>) stack.clone();

        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}