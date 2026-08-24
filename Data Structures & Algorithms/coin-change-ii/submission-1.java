class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] cache = new int[coins.length+1][amount+1];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, amount, coins, cache);
    }

    private int dfs(int i, int remainder, int[] coins, int[][]cache) {
        if(remainder == 0) {
            return 1;
        }

        if(i >= coins.length) {
            return 0;
        }

        if(cache[i][remainder] != -1) {
            return cache[i][remainder];
        }

        int res = 0;
        if(remainder >= coins[i]) {
            res = dfs(i+1, remainder, coins, cache);
            res += dfs(i, remainder - coins[i], coins, cache);
        }
        cache[i][remainder] = res;
        return cache[i][remainder];
    }
}
