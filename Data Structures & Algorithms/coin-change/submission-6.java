class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        Arrays.fill(cache, -1);
        int res = dfs(amount, coins, cache);
        return res != Integer.MAX_VALUE ? res : -1;
    }

    private int dfs(int remainder, int[]coins, int[]cache) {
        if(remainder == 0 ) {
            return 0;
        }

        if(cache[remainder] != -1) {
            return cache[remainder];
        }

        int finalPerCoinResult = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(coin <= remainder) {
                int result = dfs(remainder - coin, coins, cache);
            if(result != Integer.MAX_VALUE) {
                finalPerCoinResult = Math.min(finalPerCoinResult, 1+ result);
            }
            }
        }
        cache[remainder] = finalPerCoinResult;
        return cache[remainder];

    }
}
