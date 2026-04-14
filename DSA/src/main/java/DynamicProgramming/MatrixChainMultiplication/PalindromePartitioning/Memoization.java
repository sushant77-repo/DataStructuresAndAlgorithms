package DynamicProgramming.MatrixChainMultiplication.PalindromePartitioning;

import java.util.Arrays;

public class Memoization {
    static int[][] dp;
    public static void main(String[] args) {
        String s = "abcbx";
        int i = 0;
        int j = s.length() - 1;

        // initialize dp
        dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("=============== " + palindromePartitioning(s, i, j) + " ===============");
    }

    private static int palindromePartitioning(String s, int i, int j) {
        // base case
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }

        // check if already computed
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = palindromePartitioning(s, i , k)
                    + palindromePartitioning(s, k + 1, j)
                    + 1;
            ans = Math.min(ans, temp);
        }

        // store in DP for future references
        dp[i][j] = ans;

        return ans;
    }

    private static boolean isPalindrome(String s, int i , int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
