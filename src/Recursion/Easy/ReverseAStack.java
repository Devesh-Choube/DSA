import java.util.Stack;

/*
Problem: Reverse a Stack
Platform: TUF
Difficulty: Easy

Approach:
1. Recursively pop elements until the stack contains only one element.
2. While returning from recursion, insert each popped element at the bottom
   of the stack using another recursive function.
3. The insertAtBottom() function recursively removes all elements, inserts
   the current element into the empty stack, and restores the removed elements.

Time Complexity: O(N²)
- Each insertion may traverse the entire stack.

Space Complexity: O(N)
- Recursive call stack.
*/

public class ReverseAStack {

    public void reverseStack(Stack<Integer> stack) {
        if (stack.size() <= 1) {
            return;
        }

        int current = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, current);
    }

    private void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack (Top → Bottom)");
        printStack(stack);

        ReverseAStack solution = new ReverseAStack();
        solution.reverseStack(stack);

        System.out.println("\nReversed Stack (Top → Bottom)");
        printStack(stack);
    }

    private static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = (Stack<Integer>) stack.clone();

        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }
}