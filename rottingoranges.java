import java.util.LinkedList;
import java.util.Queue;

public class rottingoranges {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        // Count fresh oranges and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!rottenQueue.isEmpty() && freshOranges > 0) {
            int size = rottenQueue.size();

            for (int i = 0; i < size; i++) {
                int[] current = rottenQueue.poll();

                for (int[] direction : directions) {
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        // Make the adjacent fresh orange rotten
                        grid[newRow][newCol] = 2;
                        rottenQueue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }

            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        rottingoranges solution = new rottingoranges();

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minimum minutes to rot all oranges: " + result);
    }
}

