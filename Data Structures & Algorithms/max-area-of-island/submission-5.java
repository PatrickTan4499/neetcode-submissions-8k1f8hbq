class Solution {
    int maxIsland = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = findArea(i, j, grid);
                    if(area > maxIsland) {
                        maxIsland = area;
                    }
                }
            }
        }
        return maxIsland;
    }

    private int findArea(int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;
        int area = 1;
        area += findArea(row - 1, col, grid);
        area += findArea(row + 1, col, grid);
        area += findArea(row, col - 1, grid);
        area += findArea(row, col + 1, grid);

        return area;


    }
}
