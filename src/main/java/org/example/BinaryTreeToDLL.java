package org.example;

public class BinaryTreeToDLL {
    /**
     * Given a root of binary tree (BT), convert it to a Doubly Linked List (DLL) in place using the same node structure. The left and right pointers in the binary tree nodes should be used as prev and next pointers respectively in the resulting DLL .The DLL should be formed by performing an inorder traversal of the binary tree (i.e., Left → Root → Right).The first node in the inorder traversal (i.e., the leftmost node) should become the head of the DLL. Return the head of the resulting DLL.
     * Note: h is the tree's height, and this space is used implicitly for the recursion stack.
     *
     * TreeToList
     *
     * Examples:
     *
     * Input: root = [1, 2, 3]
     * Output: [3, 1, 2]
     *
     * Explanation: DLL would be 3<=>1<=>2
     * Input:  root = [10, 20, 30, 40, 60]
     * Output: [40, 20, 60, 10, 30]
     *
     * Explanation: DLL would be 40<=>20<=>60<=>10<=>30.
     * Constraints:
     * 1 ≤ Number of nodes ≤ 105
     * 0 ≤ Data of a node ≤ 105
    */
    class Node {
        int data;
        Node left, right;

        Node() {
            this.data = 0;
            this.left = this.right = null;
        }

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    Node head = null;
    Node end = null;
    Node bToDLL(Node root) {
        if(root == null) {
            return root;
        }
        bToDLL(root.left);
        if (head == null) {
            head = root;
        }
        if (end == null) {
            end = root;
        } else {
            end.right = root;
            root.left = end;
            end = root;
        }
        bToDLL(root.right);
        return head;
    }
}
