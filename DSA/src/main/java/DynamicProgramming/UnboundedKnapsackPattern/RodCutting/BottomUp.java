package DynamicProgramming.UnboundedKnapsackPattern.RodCutting;

public class BottomUp {
    public static void main(String[] args) {
        int[] len = {1, 2, 3, 4, 5};
        int[] price = {2, 8, 12, 14, 16};
        int l = 5;
        System.out.println("=============== " + rodCutting(len, price, l, len.length) + " ===============");
    }

    public static int rodCutting(int[] len, int[] price, int n, int l) {
        // create and initialize dp based on base case
        int[][] dp = new int[n + 1][l + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= l; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i =  1; i <= n; i++) {
            for (int j = 1; j<= n; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][l];
    }
}
