/*
678. Valid Parenthesis String - (MEDIUM)

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

https://leetcode.com/problems/valid-parenthesis-string/description/
*/

class Solution {
    //Time Complexity - O(N), Space Complexity - O(1)
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;
        for (int i = 0; i <= length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }
            
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }

        return true;
    }
}
