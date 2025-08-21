package org.example;

import java.util.Stack;

public class SymmetricTreeRecursive {
    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     * Example 2:
     *
     *
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
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

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode) {
        if(null == leftNode && null == rightNode) {
            return true;
        }
        if (null == leftNode || null == rightNode) {
            return false;
        }
        return (leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left));
    }
}
