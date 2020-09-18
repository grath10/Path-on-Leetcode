package com.june.leetcode.editor.cn;

//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 973 👎 0


public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        int result = solution.longestValidParentheses("(()");
        System.out.println(result);

        result = solution.longestValidParentheses(")()())");
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}