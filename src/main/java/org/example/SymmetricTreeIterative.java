package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymmetricTreeIterative {
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
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode leftNode = stack.pop();
            TreeNode rightNode = stack.pop();
            if (leftNode == null && rightNode == null)
                continue;
            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            stack.push(leftNode.left);
            stack.push(rightNode.right);
            stack.push(leftNode.right);
            stack.push(rightNode.left);

        }
        return true;
    }
}
