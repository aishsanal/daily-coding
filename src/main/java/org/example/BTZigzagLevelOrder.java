package org.example;

import java.util.*;

public class BTZigzagLevelOrder {
    /**
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[20,9],[15,7]]
     * Example 2:
     *
     * Input: root = [1]
     * Output: [[1]]
     * Example 3:
     *
     * Input: root = []
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 2000].
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        List<Integer> currRes;
        boolean flag = false;
        while (!queue.isEmpty()) {
            currRes = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode currNode = queue.poll();
                currRes.add(currNode.val);
                addToQueue(queue, currNode.left);
                addToQueue(queue, currNode.right);
            }
            if (flag) {
                Collections.reverse(currRes);
            }
            flag = !flag;
            res.add(currRes);
        }
        return res;
    }
    private void addToQueue(Queue<TreeNode> queue, TreeNode node) {
        if (node != null) {
            queue.add(node);
        }
    }
}
