class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for(int i = 1; i<= n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] time : times) {
            adjacencyList.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Set<Integer> seen = new HashSet<>();
        int time = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{0, k});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if(seen.contains(curr[1])) {
                continue;
            }

            seen.add(curr[1]);
            time = curr[0];

            for(int[] neighbor : adjacencyList.get(curr[1])) {
                if(seen.contains(neighbor[0])) {
                    continue;
                }
                minHeap.offer(new int[]{curr[0] + neighbor[1], neighbor[0]});
            }
        }
        return seen.size() == n ? time : -1;
    }
}
