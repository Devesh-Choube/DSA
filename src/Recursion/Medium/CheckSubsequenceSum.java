package Recursion.Medium;

/*
 * Problem: Check if a Subsequence with Sum K Exists
 * Platform: TUF
 * Difficulty: Medium
 *
 * Approach:
 * 1. At every index, we have two choices:
 *    - Include the current element in the subsequence.
 *    - Exclude the current element from the subsequence.
 * 2. Recursively explore both choices.
 * 3. When all elements are processed, check whether the
 *    current sum is equal to K.
 * 4. If any recursive path produces sum K, return true.
 *
 * Time Complexity:
 * O(2^n)
 * where n is the number of elements in the array.
 *
 * Space Complexity:
 * O(n) auxiliary recursion stack.
 *
 * No extra space is used to store all subsequences.
 */

public class CheckSubsequenceSum {

    public Boolean checkSubsequenceSumK(int[] nums, int k) {
        return check(nums, k, 0, 0);
    }

    private boolean check(int[] nums, int k, int i, int sum) {

        // Base case: all elements have been considered.
        if (i == nums.length) {
            return sum == k;
        }

        // Include the current element in the subsequence.
        if (check(nums, k, i + 1, sum + nums[i])) {
            return true;
        }

        // Exclude the current element from the subsequence.
        if (check(nums, k, i + 1, sum)) {
            return true;
        }

        // No subsequence with sum K was found.
        return false;
    }

    public static void main(String[] args) {

        CheckSubsequenceSum cs = new CheckSubsequenceSum();

        int[] nums = {1, 2, 1};
        int k = 2;

        boolean result = cs.checkSubsequenceSumK(nums, k);

        System.out.println("Array: [1, 2, 1]");
        System.out.println("Target Sum: " + k);
        System.out.println("Subsequence with sum K exists: " + result);
    }
}