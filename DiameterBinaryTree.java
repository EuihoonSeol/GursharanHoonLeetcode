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
    int diameter=-1;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        diameterHelper(root);
        return diameter;
    }
    public int diameterHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=diameterHelper(root.left);
        int rightHeight=diameterHelper(root.right);
        diameter=Math.max(diameter,Math.abs(leftHeight+rightHeight));
        return Math.max(leftHeight,rightHeight)+1;
    }
}
