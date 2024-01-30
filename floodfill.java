public class floodfill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        int originalColor = image[sr][sc];

        // Perform DFS to fill the connected region
        dfs(image, sr, sc, originalColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != originalColor || image[row][col] == newColor) {
            return;
        }

        // Fill the current cell with the new color
        image[row][col] = newColor;

        // Explore neighboring cells
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
    }

    public static void main(String[] args) {
        floodfill solution = new floodfill();

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        int[][] result = solution.floodFill(image, sr, sc, newColor);

        System.out.println("Original Image:");
        printMatrix(image);

        System.out.println("\nImage after Flood Fill:");
        printMatrix(result);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

