public class CompleteTreeNodes {

        public int countNodes(TreeNode root) {
            return countNodesUtil(root);
        }

        public static int countNodesUtil(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftCount = countNodesUtil(node.left);
            int rightCount = countNodesUtil(node.right);

            return leftCount + rightCount + 1;
        }
        // time O(n), space O(n) where n is the number of elements in tree.
    }

