import java.util.LinkedList;
import java.util.Queue;

public class shortestpathbinarymatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // Start from (0, 0) with distance 1

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentDistance = current[2];

            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return currentDistance;
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1; // Mark the cell as visited
                    queue.offer(new int[]{newRow, newCol, currentDistance + 1});
                }
            }
        }

        return -1; // No valid path found
    }

    public static void main(String[] args) {
        shortestpathbinarymatrix solution = new  shortestpathbinarymatrix();

        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        int result = solution.shortestPathBinaryMatrix(grid);
        System.out.println("Shortest Path Length: " + result);
    }
}

