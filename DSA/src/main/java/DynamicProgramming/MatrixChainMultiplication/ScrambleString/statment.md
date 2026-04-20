**Leetcode 87 - Scramble Strings**

https://leetcode.com/problems/scramble-string/description/

Given two string s1 and s2 of the same length, return true if s2 is a scrambled string of s1; otherwise, return false.

Example:
Input: s1 = "great", s2 = "rgeat"
Output: true
Explanation: One possible scenario applied to s1 is:
"great" --> "gr/eat" // divide at random index.
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
"gr/eat" --> "g/r / e/at" // apply the same algorithm recursively to both substrings. divide each at a random index.
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and keep the second substring in the same order.
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
The algorithm stops here, and the resulting string is "rgeat", which is s2.
Since one possible scenario scrambles s1 into s2, we return true.