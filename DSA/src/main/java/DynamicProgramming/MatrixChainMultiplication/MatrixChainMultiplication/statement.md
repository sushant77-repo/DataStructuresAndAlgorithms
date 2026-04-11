Given the array of sizes of matrix, return the minimum cost required to multiply all.

If we have n size array, we have n - 1 matrices. And size of every matrix is defined as below:
Matrix Ai = arr[i - 1] * arr[i]

E.g. arr = {40, 20, 30, 10, 30}

below will be sizes of matrixes:

1. A1 = 40 * 20
2. A2 = 20 * 30
3. A3 = 30 * 10
4. A4 = 10 * 30

We need to find minimum cost required for multiplication

Another example:
arr = {10, 20, 30, 10};
A1 = 10 * 20
A2 = 20 * 30
A3 = 30 * 10

Cost of A1 * (A2 * A3) ->
20 * 30 * 10 = 6000
10 * 20 * 10 = 2000
Total cost -> 8000

Cost of (A1 * A2) * A3 ->
10 * 20 * 30 -> 6000
10 * 30 * 10 -> 3000
Total cost -> 9000

So the ans is 8000