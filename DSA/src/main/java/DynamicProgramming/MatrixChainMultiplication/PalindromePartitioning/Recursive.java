package DynamicProgramming.MatrixChainMultiplication.PalindromePartitioning;

public class Recursive {
    public static void main(String[] args) {
        String s = "abcbx";
        int i = 0;
        int j = s.length() - 1;
        System.out.println("=============== " + palindromePartitioning(s, i, j) + " ===============");
    }

    private static int palindromePartitioning(String s, int i, int j) {
        // base case
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = palindromePartitioning(s, i , k)
                    + palindromePartitioning(s, k + 1, j)
                    + 1;
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    private static boolean isPalindrome(String s, int i , int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
