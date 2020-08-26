/*
      Use in order transversal as we have to compare that they are in that order */
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> mystack=new Stack();
        TreeNode current=root;
        double minval=-Double.MAX_VALUE;
        while(current!=null || !mystack.isEmpty()){
            while(current!=null){
            mystack.push(current);
            current=current.left;
            }
            TreeNode node=mystack.pop();
            if(node.val<=minval){
                return false;
            }
            minval=node.val;
            current=node.right;
        }        
        return true;
    }
}
