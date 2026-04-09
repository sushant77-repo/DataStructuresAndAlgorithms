package DynamicProgramming.LongestCommonSubsequence.SequencePatternMatching;

public class BottomUp {
    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";

        int m = s1.length();
        int n = s2.length();

        System.out.println("=============== " + isSubsequence(s1, s2, m, n) + " ===============");
    }

    public static boolean isSubsequence(String s1, String s2, int m, int n) {
        // create and initialize dp
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // fill up the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n] == m;
    }
}
