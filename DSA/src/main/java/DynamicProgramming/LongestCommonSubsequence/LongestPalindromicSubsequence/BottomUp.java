package DynamicProgramming.LongestCommonSubsequence.LongestPalindromicSubsequence;

public class BottomUp {
    public static void main(String[] args) {
        String s1 = "agbcba";

        System.out.println("=============== " + longestPalindromicSubsequence(s1) + " ===============");
    }

    public static int longestPalindromicSubsequence(String s) {
        // reverse the given string
        String rev = new StringBuilder(s).reverse().toString();

        int m = s.length();
        int n = rev.length();

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
        // logic similar to LCS
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
