/*
988. Smallest String Starting From Leaf - Medium

You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.
https://leetcode.com/problems/smallest-string-starting-from-leaf/description/


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
 /*
 Let n be the number of nodes in the binary tree.

Time complexity: O(n⋅n)

During each node visit in DFS, a new string is constructed by concatenating characters. Since string concatenation takes O(n) time, where n is the length of the resulting string, and the length of the string grows with each recursive call, the time complexity of constructing and comparing each string in the worst case(skewed tree) is O(n). Additionally, each node in the tree is visited once.

Thus, the overall time complexity of the algorithm is O(n⋅n)

Space complexity: O(n⋅n)

This space is utilized for the recursive function calls on the call stack during the DFS traversal, which is equal to the height of the tree. In the worst-case scenario, when the tree is completely unbalanced (skewed), the height of the tree can be equal to the number of nodes, resulting in O(n)) space complexity.

In addition to the recursive call stack, the algorithm creates and stores a string for each node. In the worst-case scenario, where the tree is completely unbalanced and each node visit results in a new string, the total space required to store these strings becomes O(n⋅n).

Thus, the overall space complexity of the algorithm is O(n⋅n)
*/
class Solution {
    //Time Complexity - O(N*N) and SPace complexity- O(N.N)
    String smallestStr = "";
    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeafUtil(root, "");
        return smallestStr;
    }

    public void smallestFromLeafUtil(TreeNode root, String curStr) {
        if(root == null) return;

        curStr = (char) (root.val + 'a') + curStr;
        if(root.left == null && root.right == null){
            if(smallestStr.isEmpty() || smallestStr.compareTo(curStr) > 0){
                smallestStr = curStr;
            }
        }
        if(root.left != null){
            smallestFromLeafUtil(root.left, curStr);
        }
        if(root.right != null){
            smallestFromLeafUtil(root.right, curStr);
        }
    }

}
