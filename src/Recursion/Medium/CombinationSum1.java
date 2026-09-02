package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Combination Sum I
 * Platform: LeetCode 39 / TUF
 * Difficulty: Medium
 *
 * Approach:
 * 1. At every index, we have two choices:
 *    - Pick the current element.
 *    - Do not pick the current element.
 *
 * 2. If we pick an element, we keep the same index because
 *    the same element can be used multiple times.
 *
 * 3. After picking an element, we backtrack by removing it
 *    from the current combination.
 *
 * 4. If we do not pick the current element, we move to the
 *    next index.
 *
 * 5. When all elements are processed, if the remaining target
 *    is zero, the current combination is a valid answer.
 *
 * Sorting:
 * The candidates are sorted so that smaller elements are
 * considered first. This also makes the search more organized.
 *
 * Time Complexity:
 * O(2^n) approximately for the recursion tree.
 * The actual complexity depends on the target and the
 * candidate values because elements can be reused multiple times.
 *
 * Space Complexity:
 * O(T) auxiliary recursion stack in the worst case,
 * where T depends on the target and the smallest candidate.
 *
 * Output Space:
 * O(number of valid combinations × average combination length).
 */

public class CombinationSum1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        // Sort candidates to consider smaller elements first.
        Arrays.sort(candidates);

        find(0, candidates, res, target, new ArrayList<>());

        return res;
    }

    private void find(int i, int[] candidates,
                      List<List<Integer>> res,
                      int target,
                      List<Integer> current) {

        // Base case: all candidates have been considered.
        if (i == candidates.length) {

            // Remaining target is zero, so a valid combination is found.
            if (target == 0) {
                res.add(new ArrayList<>(current));
            }

            return;
        }

        // PICK:
        // Pick the current element only if it does not exceed
        // the remaining target.
        if (target >= candidates[i]) {

            current.add(candidates[i]);

            // Same index because the current element can be
            // picked multiple times.
            find(i, candidates, res,
                    target - candidates[i], current);

            // Backtrack: remove the element before trying
            // another possibility.
            current.remove(current.size() - 1);
        }

        // NOT PICK:
        // Move to the next candidate.
        find(i + 1, candidates, res, target, current);
    }

    public static void main(String[] args) {

        CombinationSum1 combinationSum1 = new CombinationSum1();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> res =
                combinationSum1.combinationSum(candidates, target);

        System.out.println(res);
    }
}