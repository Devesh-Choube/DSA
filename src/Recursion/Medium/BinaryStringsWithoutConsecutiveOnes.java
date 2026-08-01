package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Generate Binary Strings Without Consecutive 1s
 * Platform: TUF
 * Difficulty: Medium
 *
 * Approach:
 * 1. Build the binary string one character at a time using recursion.
 * 2. '0' can always be added.
 * 3. '1' can be added only when the previous character is not '1'.
 * 4. Once the string reaches length n, add it to the result.
 *
 * Since '0' is explored before '1', the strings are generated
 * in lexicographically increasing order.
 *
 * Time Complexity:
 * O(n * F(n))
 * where F(n) is the number of valid binary strings.
 *
 * Space Complexity:
 * O(n) auxiliary recursion stack.
 * Output space: O(n * F(n)).
 */

public class BinaryStringsWithoutConsecutiveOnes {

    public List<String> generateBinaryStrings(int n) {
        List<String> list = new ArrayList<>();
        findBinaryStrings(list, "", n);
        return list;
    }

    private void findBinaryStrings(List<String> list, String string, int n) {

        // Base case: valid string of length n is formed.
        if (string.length() == n) {
            list.add(string);
            return;
        }

        // If the previous character is not 1,
        // both 0 and 1 can be added.
        if (string.isEmpty() || string.charAt(string.length() - 1) != '1') {
            findBinaryStrings(list, string + "0", n);
            findBinaryStrings(list, string + "1", n);
        } else {
            // Previous character is 1, so only 0 can be added.
            findBinaryStrings(list, string + "0", n);
        }
    }

    public static void main(String[] args) {
        BinaryStringsWithoutConsecutiveOnes obj =
                new BinaryStringsWithoutConsecutiveOnes();

        System.out.println("n = 3: " + obj.generateBinaryStrings(3));
        System.out.println("n = 4: " + obj.generateBinaryStrings(4));
        System.out.println("n = 5: " + obj.generateBinaryStrings(5));
    }
}