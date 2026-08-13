package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Generate Parentheses
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * Use backtracking to generate only valid parentheses combinations.
 *
 * 1. Add '(' if the number of opening parentheses used is less than n.
 * 2. Add ')' only if the number of closing parentheses is less than the
 *    number of opening parentheses.
 * 3. When the string length reaches 2 * n, add it to the result.
 *
 * Time Complexity: O(Cn * n)
 *   - Cn is the nth Catalan number (number of valid combinations).
 *   - Each valid combination has length 2n.
 *
 * Space Complexity: O(Cn * n)
 *   - Stores all valid combinations.
 *   - O(n) recursion depth.
 */

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<>();

        if (n == 0) {
            return list;
        }

        generateValidParentheses(n, list, "", 0, 0);

        return list;
    }

    private void generateValidParentheses(
            int n,
            List<String> list,
            String string,
            int open,
            int close) {

        // A complete valid combination has 2 * n parentheses.
        if (string.length() == n * 2) {
            list.add(string);
            return;
        }

        // Add '(' if we still have opening parentheses available.
        if (open < n) {
            generateValidParentheses(
                    n,
                    list,
                    string + '(',
                    open + 1,
                    close
            );
        }

        // Add ')' only when there is an unmatched '('.
        if (close < open) {
            generateValidParentheses(
                    n,
                    list,
                    string + ')',
                    open,
                    close + 1
            );
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();

        List<String> list = gp.generateParentheses(3);

        System.out.println(list);
    }
}