package manarprompsolution;

public class IslandCount {
    /*
     * First Interview 
     * Given a 2D array binaryMatrix of 0s and 1s, 
     * implement a function getNumberOfIslands that returns 
     *  the number of islands of 1s in binaryMatrix.
     */

    static boolean visited[][];

    public static void main(String args[]) {
        int arr[][] = {{0}};
        System.out.println(getNumberOfIslands(arr));
        int arr2[][] = {{1}};
        System.out.println(getNumberOfIslands(arr2));
        int arr3[][] = {{1, 0, 1, 0}};
        System.out.println(getNumberOfIslands(arr3));
        int arr4[][] = {{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(getNumberOfIslands(arr4));
        int arr5[][] = {{1, 0, 1, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 1, 0, 1}};
        System.out.println(getNumberOfIslands(arr5));
        int arr6[][] = {{0, 1, 0, 1, 0}, {0, 0, 1, 1, 1}, {1, 0, 0, 1, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}};
        System.out.println(getNumberOfIslands(arr6));
        int arr7[][] = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(getNumberOfIslands(arr7));

    }

    static int getNumberOfIslands(int[][] binaryMatrix) {
        // your code goes here
        if (binaryMatrix == null || binaryMatrix.length == 0) {
            return 0;
        }
        visited = new boolean[binaryMatrix.length][binaryMatrix[0].length];
        int sum = 0;
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[0].length; j++) {
                if (!visited[i][j] && binaryMatrix[i][j] != 0) {
                    DFS(binaryMatrix, i, j);
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private static void DFS(int binaryMatrix[][], int row, int col) {
        if (row < 0 || col < 0 || binaryMatrix.length <= row || binaryMatrix[0].length <= col
                || visited[row][col]
                || binaryMatrix[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        DFS(binaryMatrix, row, col + 1);
        DFS(binaryMatrix, row, col - 1);
        DFS(binaryMatrix, row + 1, col);
        DFS(binaryMatrix, row - 1, col);

    }
}
