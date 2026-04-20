package DynamicProgramming.MatrixChainMultiplication.BooleanParenthesis;

import java.util.HashMap;
import java.util.Map;

public class Memoization {
    static Map<String, Integer> dp;
    public static void main(String[] args) {
        String expression = "T^F|T";
        int i = 0;
        int j = expression.length() - 1;


        // initialize DP
        dp = new HashMap<>();

        System.out.println("=============== " + booleanParenthesis(expression, i, j, true) + " ===============");
    }

    private static int booleanParenthesis(String s, int i, int j, boolean isTrue) {
        // base case
        if (i > j) {
            return 0;
        }

        if (i == j) {
            boolean flag;
            if (isTrue) {
                flag = s.charAt(i) == 'T';
            } else {
                flag = s.charAt(i) == 'F';
            }

            return flag ? 1 : 0;
        }

        String key = i + ":" + j + ":" + isTrue;

        // check if pre-calculated
        if (dp.containsKey(key)) return dp.get(key);

        int ans = 0;
        // k jumps two places since operator will be at every second index
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = booleanParenthesis(s, i, k - 1, true);
            int leftFalse = booleanParenthesis(s, i, k - 1, false);
            int rightTrue = booleanParenthesis(s, k + 1, j, true);
            int rightFalse = booleanParenthesis(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }
            }

            if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                } else {
                    ans += leftFalse * rightFalse;
                }
            }

            if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans += (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }
        }

        // put in dp for future reference
        dp.put(key, ans);

        return ans;
    }
}
