
    /*
     * LeetCode 1922 - Count Good Numbers
     *
     * Approach:
     * 1. Even indices (0, 2, 4, ...) can contain 5 digits: {0, 2, 4, 6, 8}.
     * 2. Odd indices (1, 3, 5, ...) can contain 4 digits: {2, 3, 5, 7}.
     *
     * Number of even positions = (n + 1) / 2
     * Number of odd positions  = n / 2
     *
     * Total Good Numbers:
     *      5^((n + 1) / 2) * 4^(n / 2)
     *
     * Since n can be as large as 10^15, normal exponentiation is too slow.
     * Binary Exponentiation (Fast Power) computes powers in O(log n).
     *
     * Time Complexity : O(log n)
     * Space Complexity: O(log n) (Recursive Call Stack)
     */

    public class CountGoodNumbers {
        private static final long MOD = 1_000_000_007L;

        public int countGoodNumbers(long n) {

            long even = (n + 1) / 2;
            long odd = n / 2;

            return (int) ((power(even, 5) * power(odd, 4)) % MOD);
        }

        private long power(long exp, int base) {

            if (exp == 0)
                return 1;

            if (exp == 1)
                return base;

            long half = power(exp / 2, base);

            long result = (half * half) % MOD;

            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            return result;
        }

        public static void main(String[] args) {

            CountGoodNumbers solution = new CountGoodNumbers();

            System.out.println(solution.countGoodNumbers(1));   // 5
            System.out.println(solution.countGoodNumbers(4));   // 400
            System.out.println(solution.countGoodNumbers(50));  // 564908303
        }
    }

