package DynamicProgramming.MatrixChainMultiplication.PalindromePartitioning;

import java.util.Arrays;

public class Optimized {
    public static void main(String[] args) {
        String s = "abcbx";
        int i = 0;
        int j = s.length() - 1;

        System.out.println("=============== " + palindromePartitioning(s) + " ===============");
    }

    private static int palindromePartitioning(String s) {
        int n = s.length();

        // create and populate isPalindrome array
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && ((i - j <= 2) || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
