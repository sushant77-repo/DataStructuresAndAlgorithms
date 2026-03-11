package DynamicProgramming.UnboundedKnapsackPattern.RodCutting;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;
    public static void main(String[] args) {
        int[] len = {1, 2, 3, 4, 5};
        int[] price = {2, 8, 12, 14, 16};
        int l = 5;
        int n = len.length;

        // initialize dp
        dp = new int[n + 1][l + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        System.out.println("=============== " + rodCutting(len, price, l, len.length) + " ================");
    }

    public static int rodCutting(int[] len, int[] price, int n, int l) {
        if (l == 0 || n == 0) {
            return 0;
        }

        // check the value in dp if calculated
        if (dp[n][l] != -1) return dp[n][l];

        // otherwise calculate, store and return
        if (len[n - 1] <= l) {
            dp[n][l] = Math.max(price[n - 1] + rodCutting(len, price, n, l - len[n - 1]),
                    rodCutting(len, price, n - 1, l));
        } else {
            dp[n][l] = rodCutting(len, price, n - 1, l);
        }

        return dp[n][l];
    }
}
