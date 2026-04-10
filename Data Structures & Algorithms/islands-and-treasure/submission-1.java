class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //find all 0's
        List<Pair<Integer, Integer>> treasures = new ArrayList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    treasures.add(new Pair<>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> treasure : treasures) {
            bfs(treasure.getKey(), treasure.getValue(), grid, 0);
        }
    
    }

    private void bfs(int row, int col, int[][] grid, int distance) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
        grid[row][col] == -1 || grid[row][col] < distance) {
            return;
        }

        if(grid[row][col] > distance) {
            grid[row][col] = distance;
        }

        bfs(row - 1, col, grid, distance +1);
        bfs(row + 1, col, grid, distance +1);
        bfs(row, col - 1, grid, distance +1);
        bfs(row, col + 1, grid, distance +1);
    }
}
