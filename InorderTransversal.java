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
 1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done. 
      1
  2      3
 4  5   6  7
 current ->3
 mylist->4,2,5,1,6,7,3
 mystack->null

 Left, root, right
 4,2,5,1,6,3,7
 
 
 
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> mylist=new ArrayList<>();
        Stack<TreeNode> mystack=new Stack<>();
        TreeNode current=root;
        while(current!=null || !mystack.empty()){
            while(current!=null){
                mystack.push(current);
                current=current.left;
            }
            current=mystack.pop();
            mylist.add(current.val);
            current=current.right;
        }
        
        return mylist;
    }
}
