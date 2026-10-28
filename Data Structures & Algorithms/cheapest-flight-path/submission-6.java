class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for(int i = 0; i<= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);

            for(int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int price = flight[2];

                if(prices[s] == Integer.MAX_VALUE) {
                    continue;
                }

                if(price + prices[s] < temp[d]) {
                    temp[d] = price + prices[s];
                }
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
