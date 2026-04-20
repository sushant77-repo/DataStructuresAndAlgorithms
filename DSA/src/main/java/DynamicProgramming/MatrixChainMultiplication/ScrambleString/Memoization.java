package DynamicProgramming.MatrixChainMultiplication.ScrambleString;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    static Map<String, Boolean> dp;

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        // initialize dp
        dp = new HashMap<>();
        
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

        // check if already calculated
        String key = s1 + " " + s2;
        if (dp.containsKey(key)) return dp.get(key);

        for (int i = 1; i < n; i++) {
            if ((scrambleStrings(s1.substring(0, i), s2.substring(n - i, n))
                    && scrambleStrings(s1.substring(i, n), s2.substring(0, n - i)))
                    || (scrambleStrings(s1.substring(0, i), s2.substring(0, i))
                    && scrambleStrings(s1.substring(i, n), s2.substring(i, n)))) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}
