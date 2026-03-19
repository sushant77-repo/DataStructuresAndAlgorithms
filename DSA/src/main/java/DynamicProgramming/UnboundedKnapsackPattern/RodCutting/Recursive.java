package DynamicProgramming.UnboundedKnapsackPattern.RodCutting;

public class Recursive {
    public static void main(String[] args) {
        int[] len = {1, 2, 3, 4, 5};
        int[] price = {2, 8, 12, 14, 16};
        int l = 5;
        System.out.println("=============== " + rodCutting(len, price, l, len.length) + " ===============");
    }

    public static int rodCutting(int[] len, int[] price, int n, int l) {
        // base case
        if (l == 0 || n == 0) {
            return 0;
        }

        // recursive logic - choice diagram
        if (len[n - 1] <= l) {
            return Math.max(price[n - 1] + rodCutting(len, price, n, l - len[n - 1]),
                    rodCutting(len, price, n - 1, l));
            // only difference with 0-1 knapsack is we used n at line#16 instead of n - 1 since we want to revisit that length
        } else {
            return rodCutting(len, price, n - 1, l);
        }
    }
}
