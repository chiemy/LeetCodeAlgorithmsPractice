/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 */
public class MergeTwoBinaryTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return solution2(t1, t2);
    }

    public static TreeNode solution1(TreeNode t1, TreeNode t2) {

        TreeNode node = null;
        if (t1 != null || t2 != null) {
            int val1 = 0;
            int val2 = 0;
            TreeNode t1Left = null;
            TreeNode t2Left = null;
            TreeNode t1Right = null;
            TreeNode t2Right = null;
            if (t1 != null) {
                val1 = t1.val;
                t1Left = t1.left;
                t1Right = t1.right;
            }
            if (t2 != null) {
                val2 = t2.val;
                t2Left = t2.left;
                t2Right = t2.right;
            }
            node = new TreeNode(val1 + val2);
            node.left = mergeTrees(t1Left, t2Left);
            node.right = mergeTrees(t1Right, t2Right);
        }

        return node;
    }

    public static TreeNode solution2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode newNode = new TreeNode((t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0));
        newNode.left = solution2(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        newNode.right = solution2(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return newNode;
    }



}
