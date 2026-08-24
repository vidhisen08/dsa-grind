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
        traverse1(p,l1);
        traverse2(q,l2);

        return l1.equals(l2);
    }

    public void traverse1(TreeNode node1, List<Integer> l1){
        if(node1==null){
            l1.add(null);
            return;
        }
        l1.add(node1.val);
        traverse1(node1.left,l1);
        traverse1(node1.right,l1);
    }
    public void traverse2(TreeNode node2, List<Integer> l2){
        if(node2==null){
            l2.add(null);
            return;
        }
        l2.add(node2.val);
        traverse2(node2.left,l2);
        traverse2(node2.right,l2);
    }
}