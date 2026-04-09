package DynamicProgramming.LongestCommonSubsequence.SequencePatternMatching;

public class TwoPointer {
    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "ADXCPY";

        int m = s1.length();
        int n = s2.length();

        System.out.println("=============== " + isSubsequence(s1, s2, m, n) + " ===============");
    }

    public static boolean isSubsequence(String s1, String s2, int m, int n) {
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }
}
