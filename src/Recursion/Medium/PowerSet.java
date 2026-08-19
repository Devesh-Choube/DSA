package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Power Set / Subsets
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * Use backtracking to generate all possible subsets.
 *
 * For every element, we have two choices:
 *
 * 1. Include the current element in the subset.
 * 2. Don't include the current element in the subset.
 *
 * After including the element, we recursively explore that choice
 * and then remove the element to backtrack before exploring the
 * "don't include" choice.
 *
 * Time Complexity: O(n * 2^n)
 *   - There are 2^n possible subsets.
 *   - Each subset can contain up to n elements.
 *
 * Space Complexity: O(n * 2^n)
 *   - Stores all 2^n subsets.
 *   - O(n) recursion depth and current subset.
 */

public class PowerSet {

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        generatePowerSet(nums, list, new ArrayList<>(), 0);

        return list;
    }

    private void generatePowerSet(
            int[] nums,
            List<List<Integer>> list,
            List<Integer> current,
            int index) {

        // A complete subset has been formed.
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        // Include the current element.
        current.add(nums[index]);

        generatePowerSet(
                nums,
                list,
                current,
                index + 1
        );

        // Backtrack by removing the current element.
        current.remove(current.size() - 1);

        // Don't include the current element.
        generatePowerSet(
                nums,
                list,
                current,
                index + 1
        );
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();

        List<List<Integer>> list =
                powerSet.powerSet(new int[]{1, 2, 3});

        System.out.println(list);
    }
}