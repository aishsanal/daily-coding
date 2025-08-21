package org.example;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBstNoSpace {
    private int count;
    private int result;
    /**
     * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
     *
     * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
     * Note that ^ denotes the bitwise-xor operation.
     *
     * It can be proven that the answer is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: pref = [5,2,0,3,1]
     * Output: [5,7,2,3,2]
     * Explanation: From the array [5,7,2,3,2] we have the following:
     * - pref[0] = 5.
     * - pref[1] = 5 ^ 7 = 2.
     * - pref[2] = 5 ^ 7 ^ 2 = 0.
     * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
     * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
     * Example 2:
     *
     * Input: pref = [13]
     * Output: [13]
     * Explanation: We have pref[0] = arr[0] = 13.
     *
     *
     * Constraints:
     *
     * 1 <= pref.length <= 105
     * 0 <= pref[i] <= 106
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

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root, count);
        return result;
    }

    private void inOrderTraversal(TreeNode root, int count) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, count);
        count--;
        if (count == 0) {
            result = root.val;
            return;
        }
        inOrderTraversal(root.right, count);
    }
}
