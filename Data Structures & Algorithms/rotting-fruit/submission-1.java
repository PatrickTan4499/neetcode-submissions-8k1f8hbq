class Solution {
    public int orangesRotting(int[][] grid) {
        int answer = 0;
        List<Pair<Integer, Integer>> rottingFruits = new ArrayList<>();

        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottingFruits.add(new Pair<>(i, j));
                }
            }
        }
        
        for(Pair<Integer, Integer> fruit : rottingFruits) {
            bfs(fruit.getKey(), fruit.getValue(), grid, 0);
        }

        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
                if (grid[i][j] < 0) {
answer = Math.max(answer, -grid[i][j]);                }
            }
        }
        return answer;
    }

    private void bfs(int row, int col, int[][] grid, int time) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
        || grid[row][col] == 0) {
            return;
        }

// Don't spread from original rotten cells again (only at time 0)
        if (grid[row][col] == 2 && time > 0) return;

        // Already reached with equal or better time → stop
        if (grid[row][col] < 0 && -grid[row][col] <= time) {
            return;
        }

        grid[row][col] = -time;

        bfs(row - 1, col, grid, time + 1);
        bfs(row + 1, col, grid, time + 1);
        bfs(row, col -1, grid, time + 1);
        bfs(row, col + 1, grid, time + 1);
    }
}
