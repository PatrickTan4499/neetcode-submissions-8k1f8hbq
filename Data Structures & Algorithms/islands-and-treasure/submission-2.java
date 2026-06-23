class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> bfs = new LinkedList<>();
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    bfs.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 } };
        while(!bfs.isEmpty()) {
            int[] cell = bfs.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || 
                grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                bfs.add(new int[] {newRow, newCol});
                grid[newRow][newCol] = grid[row][col] +1;
            }
        }
        
    }
}
