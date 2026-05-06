package DynamicProgramming.MatrixChainMultiplication.SuperEggDrop;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;

    public static void main(String[] args) {
        int eggs = 1;
        int floors = 2;

        // initialize dp
        dp = new int[eggs + 1][floors + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("=============== " + superEggDrop(eggs, floors) + " ===============");
    }

    private static int superEggDrop(int k, int n) {
        // base case
        if (n <= 1) {
            return n;
        }

        if (k == 1) {
            return n;
        }

        // check if already calculated
        if (dp[k][n] != -1) return dp[k][n];

        int ans = Integer.MAX_VALUE;

        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            int left = superEggDrop(k - 1, mid - 1);
            int right = superEggDrop(k, n - mid);
            int temp = 1 + Math.max(left, right);
            ans = Math.min(ans, temp);

            if (left < right) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // store in DP for future use
        dp[k][n] = ans;

        return ans;
    }
}
