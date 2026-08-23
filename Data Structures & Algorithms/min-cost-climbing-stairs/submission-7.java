class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);

        return Math.min(dfs(0, cost, cache), dfs(1, cost, cache));
    }

    private int dfs(int i, int[]cost, int[] cache) {
        if(i >= cost.length) {
            return 0;
        }

        if(cache[i] != -1) {
            return cache[i];
        }

        cache[i] = cost[i] + Math.min(dfs(i+1, cost, cache), dfs(i+2, cost, cache));
        return cache[i];
    }
}
