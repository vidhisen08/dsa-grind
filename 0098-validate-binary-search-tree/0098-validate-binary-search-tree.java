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
    public boolean isValidBST(TreeNode root) {
        // TreeNode curr = root;
        // while(curr!=null){
        //    if(curr.left!=null){
        //      if(curr.left.val<curr.val){
        //         curr = curr.left;
        //         return true;
        //     }
        //     else{
        //         return false;
        //     }
        //    }

        //    if(curr.right!=null){
        //      if(curr.right.val>curr.val){
        //         curr = curr.right;
        //         return
        //     }
        //     else{
        //         return false;
        //     }
        //    }
        // }
        // return false;
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }
}