/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.</br>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.</br>
 * 思路：前一个数组和后一个数组对角比较
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        return solution2(matrix);
    }

    private boolean solution1(int[][] matrix) {
        boolean flag = false;
        for (int i = 0; i < matrix.length - 1; i++) {
            int[] current = matrix[i];
            int[] next = matrix[i + 1];
            for (int j = 0; j < current.length - 1; j++) {
                flag = current[j] == next[j + 1];
                if (!flag) {
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }

    private boolean solution2(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            int[] current = matrix[i];
            int[] next = matrix[i + 1];
            for (int j = 0; j < current.length - 1; j++) {
                if(current[j] != next[j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
