/**
 * <br>You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <br>Grid cells are connected horizontally/vertically (not diagonally).
 * <br>The grid is completely surrounded by water,
 * <br>and there is exactly one island (i.e., one or more connected land cells).
 * <br>The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * <br>One cell is a square with side length 1. T
 * <br>he grid is rectangular, width and height don't exceed 100.
 * <br>Determine the perimeter of the island.
 *
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        return solution2(grid);
    }

    // 思路：每个格子只需要关注自己的下边和右边（除了第一行和第一列，第一行的格子要关注上方，第一列的格子要关注左边）
    private int solution1(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] currentRow = grid[i];
            int[] nextRow = null;
            if (i < grid.length - 1) {
                nextRow = grid[i + 1];
            }
            for (int j = 0; j < currentRow.length; j++) {
                int isLandCell = currentRow[j];
                // 第一行顶部
                if (i == 0 && isLandCell == 1) {
                    count++;
                }
                // 第一列左边
                if (j == 0 && isLandCell == 1) {
                    count++;
                }

                int isNextLandCell = 0;
                if (j < currentRow.length - 1) {
                    isNextLandCell = currentRow[j + 1];
                }
                if (isLandCell != isNextLandCell) {
                    count++;
                }

                int isNextRowLandCell = 0;
                if (nextRow != null) {
                    isNextRowLandCell = nextRow[j];
                }
                if (isLandCell != isNextRowLandCell) {
                    count++;
                }
            }
        }
        return count;
    }

    // 思路：所有岛格 x 4 - 相邻岛格边数 x 2，
    private int solution2(int[][] grid) {
        int landCellCount = 0;
        int neighborEdgeCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    landCellCount++;
                    if (i + 1 < grid.length
                            && grid[i + 1][j] == 1) {
                        neighborEdgeCount++;
                    }
                    if (j + 1 < grid[i].length
                            && grid[i][j + 1] == 1) {
                        neighborEdgeCount++;
                    }
                }
            }
        }
        return landCellCount * 4 - neighborEdgeCount * 2;
    }
}
