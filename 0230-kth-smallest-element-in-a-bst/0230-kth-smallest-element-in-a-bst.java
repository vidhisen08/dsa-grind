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
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        TreeNode curr = root;
        int count = 0;

        while (curr != null) {

            // No left subtree
            if (curr.left == null) {
                count++;

                if (count == k)
                    return curr.val;

                curr = curr.right;
            }

            // Left subtree exists
            else {
                // Find inorder predecessor
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // First time visiting curr
                if (pred.right == null) {
                    pred.right = curr;     // create temporary link
                    curr = curr.left;
                }

                // Second time visiting curr
                else {
                    pred.right = null;    // remove temporary link
                    count++;

                    if (count == k)
                        return curr.val;

                    curr = curr.right;
                }
            }
        }

        return -1;
    }
}