class Solution {
    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length][2];

        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 1, prices, cache);
    }

    private int dfs(int i, int buyFlag, int[]prices, int[][] cache) {
        if(i >= prices.length) {
            return 0;
        }
        if(cache[i][buyFlag] != -1) {
            return cache[i][buyFlag];
        }

        int cooldown = dfs(i + 1, buyFlag, prices, cache);
        if(buyFlag == 1) {
            int buy = dfs(i+1, 0, prices, cache) - prices[i];
            cache[i][buyFlag] = Math.max(buy, cooldown);
        } else {
            int sell = dfs(i+2, 1, prices, cache) + prices[i];
            cache[i][buyFlag] = Math.max(sell, cooldown);
        }

        return cache[i][buyFlag];
    }
}
