package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {
    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
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
     * -1000 <= Node.val <= 1000
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        queue.add(root);
        List<Integer> currRes;
        while(!queue.isEmpty()) {
            currRes = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode currNode = queue.poll();
                currRes.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            res.add(currRes);
        }
        return res;
    }
}
