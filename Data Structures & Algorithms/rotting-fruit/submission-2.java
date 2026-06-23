class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        for(int i = 0; i< grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    bfs.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        while(!bfs.isEmpty() && fresh > 0) {
            int size = bfs.size();
            for(int i = 0; i< size; i++) {
                int[] curr = bfs.poll();
                for(int[] dir : dirs) {
                    int newR = curr[0] + dir[0];
                    int newC = curr[1] + dir[1];

                    if(newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length || grid[newR][newC] != 1) {
                        continue;
                    }
                    grid[newR][newC] = 2;
                    bfs.add(new int[]{newR, newC});
                    fresh--;

                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
