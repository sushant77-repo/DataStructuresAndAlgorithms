package DynamicProgramming.UnboundedKnapsackPattern.CoinChangeI;

public class BottomUp {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        int n = coins.length;

        System.out.println("=============== " + coinChange(coins, sum, n) + " ===============");
    }

    public static int coinChange(int[] coins, int sum, int n) {
        // create and initialize dp array
        // if coins is empty, mathematically we would need infinite coins to make the given sum
        // if sum = 0, we need zero coins to make the given sum
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) dp[i][j] = Integer.MAX_VALUE - 1;
                if (j == 0) dp[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }
}
