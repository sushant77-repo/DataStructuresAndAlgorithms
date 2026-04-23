package DynamicProgramming.MatrixChainMultiplication.SuperEggDrop;

public class Recursive {
    public static void main(String[] args) {
        int eggs = 1;
        int floors = 2;

        System.out.println("=============== " + superEggDrop(eggs, floors) + " ===============");
    }

    private static int superEggDrop(int k, int n) {
        // base case
        if (n <= 1) {
            return n;
        }

        if (k == 1) {
            return n;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int temp = 1 + Math.max(superEggDrop(k - 1, i - 1), superEggDrop(k, n - i));
            ans = Math.min(ans, temp);
        }

        return ans;
    }
}
