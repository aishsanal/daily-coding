package org.example;

import java.util.Stack;

public class InvertBinaryTree {
    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * Example 2:
     *
     *
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 100].
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

  //Recursive
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null)
            return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    //Iterative
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == null)
                continue;
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            stack.push(curr.left);
            stack.push(curr.right);
        }
        return root;
    }
}
