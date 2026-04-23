class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //fill with default value to check at the end
        Arrays.fill(dp, amount + 1);

        //base case
        dp[0] = 0;

        //for each dp[i], we need to check all coins to see if they can be = coin[i]
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //track min for every path
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
