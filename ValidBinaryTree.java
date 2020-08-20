/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        /*
        Using binary search tree inorder we can look in the sorted as it is already 
        sorted out.   
        inorder -> 2 1 3
        stack ->2 
        node=2
        left_node=1
        */
        if(root==null){
            return true;
        }
        Stack<TreeNode> myStack=new Stack();
        double left_child_val=- Double.MAX_VALUE;
        TreeNode current=root;
        while(!myStack.isEmpty() || current!=null ){
            while(current!=null){
                myStack.push(current);
                current=current.left;
            }
             TreeNode node=myStack.pop();
            if(node.val<=left_child_val){
                return false;
            }
            left_child_val=node.val;
            // mylist.add(node.val);            
            current=node.right;
        }
        return true;
    }
}
