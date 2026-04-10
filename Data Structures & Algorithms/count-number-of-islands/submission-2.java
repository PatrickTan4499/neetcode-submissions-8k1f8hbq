class Solution {

    public int numIslands(char[][] grid) {
        int answer = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    answer++;
                    bfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    private void bfs(int row, int col, char[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
            grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        bfs(row - 1, col, grid);
        bfs(row + 1, col, grid);
        bfs(row, col - 1, grid);
        bfs(row, col + 1, grid);

    }
}
