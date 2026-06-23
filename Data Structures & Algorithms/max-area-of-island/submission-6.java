class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        Set<String> seen = new HashSet<>();
        for(int i = 0; i< grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    
                    answer = Math.max(dfs(i, j, grid, seen), answer);
                }
            }
        }

        return answer;
    }

    private int dfs(int row, int col, int[][]grid, Set<String> seen) {
        String key = row + "," + col;
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length || 
        seen.contains(key) || grid[row][col] == 0) {
            return 0;
        }
        
        seen.add(key);
        int area = 1;
        area += dfs(row +1, col, grid, seen);
        area += dfs(row-1, col, grid, seen);
        area += dfs(row, col+1, grid, seen);
        area += dfs(row, col-1, grid, seen);
        return area;
    }
}
