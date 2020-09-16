package com.june.leetcode.editor.cn;

//Given a string s, find the longest palindromic subsequence's length in s. You 
//may assume that the maximum length of s is 1000. 
//
// Example 1: 
//Input: 
//
// 
//"bbbab"
// 
//Output:
//
// 
//4
// 
//One possible longest palindromic subsequence is "bbbb".
//
// 
//
// Example 2: 
//Input: 
//
// 
//"cbbd"
// 
//Output:
//
// 
//2
// 
//One possible longest palindromic subsequence is "bb".
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
// Related Topics 动态规划 
// 👍 290 👎 0


public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        int result = solution.longestPalindromeSubseq("bbbab");
        System.out.println(result);

        result = solution.longestPalindromeSubseq("cbbd");
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}