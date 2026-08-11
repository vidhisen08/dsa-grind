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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode curr = root;

        while (curr != null || !s.isEmpty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = s.peek().right;
                if (temp == null) {
                    temp = s.peek();
                    s.pop();
                    result.add(temp.val);

                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.peek();
                        s.pop();
                        result.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return result;
    }
}