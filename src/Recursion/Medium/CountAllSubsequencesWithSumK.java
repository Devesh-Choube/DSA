package Recursion.Medium;

/*
 * Problem: Count All Subsequences With Sum K
 * Platform: TUF
 * Difficulty: Medium
 *
 * Approach:
 * 1. At every index, we have two choices:
 *    - Take the current element.
 *    - Do not take the current element.
 * 2. Recursively explore both choices.
 * 3. When all elements are processed, check whether the
 *    current sum is equal to K.
 * 4. Return 1 if the sum is K, otherwise return 0.
 * 5. The counts from the 'take' and 'not take' branches
 *    are added to get the total number of subsequences.
 *
 * Time Complexity:
 * O(2^n)
 * where n is the number of elements in the array.
 *
 * Space Complexity:
 * O(n) auxiliary recursion stack.
 *
 * No extra space is used to store the subsequences.
 */

public class CountAllSubsequencesWithSumK {

    public int countSubsequenceWithSumK(int[] nums, int k) {
        return countSubsequence(nums, nums.length, 0, k, 0);
    }

    private int countSubsequence(int[] nums, int n, int i, int k, int sum) {

        // Base case: all elements have been considered.
        if (i == n) {
            return sum == k ? 1 : 0;
        }

        // Take the current element.
        int take = countSubsequence(
                nums, n, i + 1, k, sum + nums[i]
        );

        // Do not take the current element.
        int notTake = countSubsequence(
                nums, n, i + 1, k, sum
        );

        // Total subsequences = take + notTake.
        return take + notTake;
    }

    public static void main(String[] args) {

        int[] nums = {4, 9, 2, 5, 1};
        int k = 10;

        CountAllSubsequencesWithSumK obj =
                new CountAllSubsequencesWithSumK();

        System.out.println(
                "Number of subsequences with sum " + k + ": "
                        + obj.countSubsequenceWithSumK(nums, k)
        );
    }
}