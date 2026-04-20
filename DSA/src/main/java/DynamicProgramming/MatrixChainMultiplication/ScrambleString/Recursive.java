package DynamicProgramming.MatrixChainMultiplication.ScrambleString;

public class Recursive {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        System.out.println("=============== " + scrambleStrings(s1, s2) + " ===============");
    }

    private static boolean scrambleStrings(String s1, String s2) {
        int n = s1.length();

        // base case
        if (s1.equals(s2)) {
            return true;
        }

        if (n <= 1) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            if ((scrambleStrings(s1.substring(0, i), s2.substring(n - i, n))
                    && scrambleStrings(s1.substring(i, n), s2.substring(0, n - i)))
                    || (scrambleStrings(s1.substring(0, i), s2.substring(0, i))
                    && scrambleStrings(s1.substring(i, n), s2.substring(i, n)))) {
                return true;
            }
        }

        return false;
    }
}
