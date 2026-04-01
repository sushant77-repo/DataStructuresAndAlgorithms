package DynamicProgramming.LongestCommonSubsequence.LongestRepeatingSubsequence;

public class BottomUp {
    public static void main(String[] args) {
        String s1 = "AABEDCBD";

        System.out.println("=============== " + longestRepeatingSubsequence(s1) + " ===============");
    }

    public static int longestRepeatingSubsequence(String s) {
        int m = s.length();

        // create and initialize dp
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // fill up the table
        // logic similar to LCS with slight change
        // notice the first if condition
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][m];
    }
}
