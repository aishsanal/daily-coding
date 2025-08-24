package org.example;

import java.util.Stack;

public class BalancedBinaryTree {
    /**
     * Given a binary tree, determine if it is height-balanced.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [1,2,2,3,3,null,null,4,4]
     * Output: false
     * Example 3:
     *
     * Input: root = []
     * Output: true
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 5000].
     * -104 <= Node.val <= 104
    */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        check(root);
        return isBal;
    }
    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = check(root.left);
        int rightDepth = check(root.right);
        isBal = isBal && (Math.abs(leftDepth - rightDepth) <= 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
