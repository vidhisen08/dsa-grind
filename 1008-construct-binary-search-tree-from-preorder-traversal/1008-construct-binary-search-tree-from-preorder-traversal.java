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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            TreeNode root = node;
            while(true){
                if(preorder[i]<root.val){
                if(root.left!=null){
                    root = root.left;
                }
                else{
                    root.left = new TreeNode(preorder[i]);
                    break;
                }
            }
            else{
                if(root.right!=null){
                    root = root.right;
                }
                else{
                    root.right = new TreeNode(preorder[i]);
                    break;
                }       
            }
            }
        }
        return node;
    }
}