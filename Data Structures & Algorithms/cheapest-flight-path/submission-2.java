class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.putIfAbsent(flight[0], new ArrayList<>());
            adj.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{0, -1, src});

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int stops = curr[1];
            int u = curr[2];

            if (u == dst) {
                return cost; // Fix 1: Return cost, not stops
            }

            if (stops == k) {
                continue;
            }

            for (int[] neighbor : adj.getOrDefault(u, new ArrayList<>())) {
                int price = neighbor[0];
                int v = neighbor[1];
                int nextCost = cost + price;
                int nextStops = stops + 1;

                // Fix 2 & 3: Correct dist array index and update dist table
                if (nextCost < dist[v][nextStops + 1]) {
                    dist[v][nextStops + 1] = nextCost;
                    minHeap.offer(new int[]{nextCost, nextStops, v});
                }
            }
        }

        return -1;
    }
}
