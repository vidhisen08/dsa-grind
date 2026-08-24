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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        traverse(p,l1);
        traverse(q,l2);

        return l1.equals(l2);
    }

    public void traverse(TreeNode node, List<Integer> l){
        if(node==null){
            l.add(null);
            return;
        }
        l.add(node.val);
        traverse(node.left,l);
        traverse(node.right,l);
    }
}