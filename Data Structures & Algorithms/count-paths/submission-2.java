class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, m, n, cache);
    }

    private int dfs(int i, int j, int m, int n, int[][] cache) {
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if(i == m-1 && j == n-1) {
            return 1;
        }

        if(cache[i][j] != -1) {
            return cache[i][j];
        }

        cache[i][j] = dfs(i+1, j, m, n, cache) + dfs(i, j+1, m, n, cache); 
        return cache[i][j];
    }
}
