/**
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
        return root;
    }

    private void invert(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            invert(node.left);
            invert(node.right);
        }
    }
}
