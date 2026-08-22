class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 1; i<=n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int [] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Set<Integer> seen = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        minHeap.offer(new int[]{0,k});
        int time = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            if(seen.contains(curr[1])) {
                continue;
            }

            seen.add(curr[1]);
            time = curr[0];

            for(int[] neighbors : adj.get(curr[1])) {
                if(!seen.contains(neighbors[0])) {
                    minHeap.offer(new int[]{time + neighbors[1], neighbors[0]});
                }
            }
        }

        return seen.size() == n ? time : -1;
    }
}
