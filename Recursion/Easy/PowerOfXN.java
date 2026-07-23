
/*
Problem: Pow(x, n)
Platform: LeetCode
Problem No: 50
Difficulty: Medium
Approach: Binary Exponentiation (Divide & Conquer)

Time Complexity: O(log n)
Space Complexity: O(log n) (Recursion Stack)
*/

public class PowerOfXN {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("2^10 = " + solution.myPow(2, 10));
        System.out.println("2^-2 = " + solution.myPow(2, -2));
        System.out.println("5^0 = " + solution.myPow(5, 0));
        System.out.println("3^5 = " + solution.myPow(3, 5));
        System.out.println("2^-3 = " + solution.myPow(2, -3));
    }
}

class Solution {

    public double myPow(double x, int n) {
        long N = n;

        if (N == 0)
            return 1;

        if (N < 0)
            return 1 / calculatePow(x, -N);

        return calculatePow(x, N);
    }

    private double calculatePow(double x, long n) {

        if (n == 0)
            return 1;

        if (n == 1)
            return x;

        double half = calculatePow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}