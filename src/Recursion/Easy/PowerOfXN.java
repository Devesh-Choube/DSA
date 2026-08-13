package Recursion.Easy;
/*
Problem: Pow(x, n)
Platform: LeetCode
Problem No: 50
Difficulty: Medium

Approach:
- Use Binary Exponentiation (Divide & Conquer).
- Compute x^(n/2) recursively.
- If n is even, answer = half * half.
- If n is odd, answer = half * half * x.
- Convert n to long to safely handle Integer.MIN_VALUE.


Time Complexity: O(log n)
Space Complexity: O(log n) (Recursion Stack)
*/

public class PowerOfXN {

    public static void main(String[] args) {
        PowerOfXN solution = new PowerOfXN();

        System.out.println("2^10 = " + solution.myPow(2, 10));
        System.out.println("2^-2 = " + solution.myPow(2, -2));
        System.out.println("5^0 = " + solution.myPow(5, 0));
        System.out.println("3^5 = " + solution.myPow(3, 5));
        System.out.println("2^-3 = " + solution.myPow(2, -3));
    }

    public double myPow(double x, int n) {
        // Convert int to long to safely handle Integer.MIN_VALUE (-2^31).
        // Negating Integer.MIN_VALUE overflows an int, but not a long.
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