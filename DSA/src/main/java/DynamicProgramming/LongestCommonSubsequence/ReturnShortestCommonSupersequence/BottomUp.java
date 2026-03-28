package DynamicProgramming.LongestCommonSubsequence.ReturnShortestCommonSupersequence;

public class BottomUp {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int m = s1.length();
        int n = s2.length();

        System.out.println("=============== " + returnShortestCommonSuperSequence(s1, s2, m, n) + " ===============");
    }

    public static String returnShortestCommonSuperSequence(String s1, String s2, int m, int n) {
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
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // traverse through dp to form the string
        StringBuilder s = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    s.append(s1.charAt(i - 1));
                    i--;
                } else {
                    s.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }

        // traverse the remaining string
        while (i > 0) {
            s.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            s.append(s2.charAt(j - 1));
            j--;
        }

        // return the reverse of the formed string
        return s.reverse().toString();
    }
}
