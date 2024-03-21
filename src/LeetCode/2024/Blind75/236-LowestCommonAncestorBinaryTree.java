/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description

*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Time Complexity - O(N), Space Complexity - O(N) recursion stack
    private TreeNode ans;
    public Solution(){
        this.ans = null;
    }

    private boolean traveseTree(TreeNode curNode, TreeNode p, TreeNode q){
        if(curNode == null) return false;

        int left = traveseTree(curNode.left, p, q)? 1:0;
        int right = traveseTree(curNode.right, p, q)? 1:0;
        int mid = (curNode == p || curNode == q)?1:0;

        if(left+right+mid >=2){
            this.ans = curNode;
        }
        return (left+right+mid>0);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.traveseTree(root, p, q);
        return this.ans;
    }
}
