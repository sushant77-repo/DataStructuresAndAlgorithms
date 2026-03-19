package DynamicProgramming.LongestCommonSubsequence.LongestCommonSubsequence;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int m = s1.length();
        int n = s2.length();

        //initialize dp
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("=============== " + LCS(s1, s2, m, n) + " ===============");
    }

    public static int LCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        // return if already calculated
        if (dp[m][n] != -1) return dp[m][n];

        // calculate if not previously calculated
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + LCS(s1, s2, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(LCS(s1, s2, m - 1, n), LCS(s1, s2, m, n - 1));
        }

        return dp[m][n];
    }
}
