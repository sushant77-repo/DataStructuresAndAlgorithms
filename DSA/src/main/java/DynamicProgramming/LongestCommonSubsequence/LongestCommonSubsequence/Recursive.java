package DynamicProgramming.LongestCommonSubsequence.LongestCommonSubsequence;

public class Recursive {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int m = s1.length();
        int n = s2.length();

        System.out.println("=============== " + LCS(s1, s2, m, n) + " ================");
    }

    public static int LCS(String s1, String s2, int m, int n) {
        // base case
        // if any of the strings is empty, answer is 0
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCS(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(LCS(s1, s2, m - 1, n), LCS(s1, s2, m, n - 1));
        }
    }
}
