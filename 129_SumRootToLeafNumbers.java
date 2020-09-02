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
    public int sumNumbers(TreeNode root) {
        ArrayList<String> result=new ArrayList();
        if(root==null){
            return 0;
        }
        String current_path=Integer.toString(root.val);
        if(root.left==null&&root.right==null){
            result.add(Integer.toString(root.val));
        }
        if(root.left!=null){
            helper(root.left,current_path,result);
        }
        if(root.right!=null){
            helper(root.right,current_path,result);
        }
        int ans=0;
        for(String str:result){
            ans=ans+Integer.parseInt(str);
        }
        return ans;
    }
    public ArrayList<String> helper(TreeNode root,String current_path,ArrayList<String> result){
        if(root==null){
            return result;
        }
                    current_path=current_path+Integer.toString(root.val);

        if(root.left==null && root.right==null){
            result.add(current_path);
        }
        if(root.left!=null){
            helper(root.left,current_path,result);
        }
        if(root.right!=null){
            helper(root.right,current_path,result);
        }
        return result;
    }
}
