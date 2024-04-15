/*
129. Sum Root to Leaf Numbers (Medium)
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //Time Complexity - O(N) and Space complexity - O(H), H tree height.
class Solution {
    int sumToLeaf = 0;
    public int sumNumbers(TreeNode root) {
        sumNumUtil(root, 0);
        return sumToLeaf;
    }

    public void sumNumUtil(TreeNode root, int curSum) {
        if(root != null){
            curSum = curSum*10 + root.val;
            if(root.left == null && root.right == null){
                sumToLeaf += curSum;
            }
            sumNumUtil(root.left, curSum);
            sumNumUtil(root.right, curSum);
        }
    }
}
