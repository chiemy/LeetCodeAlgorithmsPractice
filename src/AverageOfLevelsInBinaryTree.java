import java.util.*;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        return solution1(root);
    }

    private List<Double> solution1(TreeNode root) {
        List<Double> result = new ArrayList<>();

        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);

        while (!levelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            int sum = 0;
            int size = levelNodes.size();
            for (TreeNode node : levelNodes) {
                sum += node.val;
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            levelNodes = nextLevelNodes;
            result.add((double) sum / size);
        }
        return result;
    }

    private List<Double> solution2(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add((double) sum / size);
        }
        return result;
    }

}
