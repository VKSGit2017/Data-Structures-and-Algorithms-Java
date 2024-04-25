/*
2370. Longest Ideal Subsequence - Medium
You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.


*/


/*
Let NNN be the length of s and L be the number of letters in the English alphabet, which is 26.

Time complexity: O(NL).

The outer loop iterates through the characters in s, so it runs N times. The inner loop iterates L times for each character in s. Therefore, the time complexity is O(NL). Note that L is 26, which is a constant, so we could simplify the time complexity to O(N).

Space complexity: O(L)

We use a DP array of size L. L is 26, which is a constant, so we could simplify the time complexity to O(1).
*/

class Solution {
    public int longestIdealString(String s, int k) {
        int len = s.length();
        int[] dp = new int[26];

        int result = 0;

        for(int i = 0; i<len; i++){
            int cur = s.charAt(i) - 'a';
            int curLen = 0;
            for(int j = 0; j < 26; j++){
                if(Math.abs(j - cur) <= k){
                    curLen = Math.max(curLen, dp[j]);
                }
            }

            dp[cur] = Math.max(dp[cur], curLen+1);
            result = Math.max(result, dp[cur]);
        }
        return result;
        
    }
}
