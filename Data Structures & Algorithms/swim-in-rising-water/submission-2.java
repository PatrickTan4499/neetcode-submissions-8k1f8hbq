class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1,0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            if(curr[1] == N-1 && curr[2] == N-1) {
                return curr[0];
            }

            for(int[] direction : directions) {
                int newR = curr[1] + direction[0];
                int newC = curr[2] + direction[1];

                if(newR >= 0 && newR < N && newC >= 0 && newC < N && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    minHeap.offer(new int[]{Math.max(grid[newR][newC], curr[0]), newR, newC});
                }
            }
        }

        return N * N;
    }
}
