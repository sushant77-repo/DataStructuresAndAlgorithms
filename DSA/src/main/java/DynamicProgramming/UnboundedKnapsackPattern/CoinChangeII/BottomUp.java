package DynamicProgramming.UnboundedKnapsackPattern.CoinChangeII;

public class BottomUp {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        int n = coins.length;

        System.out.println("=============== " + coinChangeII(coins, sum, n) + " ===============");
    }

    public static int coinChangeII(int[] coins, int sum, int n) {
        // create and initialize dp array
        // if sum = 0, there is always 1 way and if coins is empty, there are no ways of making any sum
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
