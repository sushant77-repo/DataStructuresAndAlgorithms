package DynamicProgramming.MatrixChainMultiplication.MatrixChainMultiplication;

public class Memoization {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int i = 1;
        int j = arr.length - 1;

        // initialize DP
        dp = new int[arr.length][arr.length];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length; c++) {
                dp[r][c] = -1;
            }
        }

        System.out.println("=============== " + matrixChainMultiplication(arr, i, j) + " ===============");
    }

    private static int matrixChainMultiplication(int[] arr, int i, int j) {
        // base case
        if (i >= j) {
            return 0;
        }

        // check if already computed
        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int curr = matrixChainMultiplication(arr, i, k) +
                    matrixChainMultiplication(arr, k + 1, j) +
                    (arr[i - 1] * arr[k] * arr[j]);
            if (curr < ans) ans = curr;
        }

        // store in DP for future references
        dp[i][j] = ans;

        return ans;
    }
}
