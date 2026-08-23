class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(0, n, cache);
        
    }

    private int dfs(int i, int n, int[] cache) {
        if(i >= n) {
            return i == n ? 1 : 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }
        cache[i] = dfs(i+1, n, cache) + dfs(i+2, n, cache);
        return cache[i];
    }
}
