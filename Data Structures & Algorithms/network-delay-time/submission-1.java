class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list: sourceNode -> List of [neighborNode, edgeWeight]
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int travelTime = time[2];
            
            adjacencyList.computeIfAbsent(source, key -> new ArrayList<>())
                         .add(new int[]{target, travelTime});
        }

        // Min-Heap stores entries as: [timeFromSource, currentNode]
        // Sorted by the shortest total time taken to reach the node
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(entry -> entry[0])
        );
        
        // Start at source node 'k' with time 0
        minHeap.offer(new int[]{0, k});

        Set<Integer> visitedNodes = new HashSet<>();
        int maxDelayTime = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentTravelTime = current[0];
            int currentNode = current[1];

            // Skip if we've already processed this node via a shorter path
            if (visitedNodes.contains(currentNode)) {
                continue;
            }

            // Process node: mark as visited and update max time needed so far
            visitedNodes.add(currentNode);
            maxDelayTime = currentTravelTime;

            // Explore all outgoing edges from the current node
            if (adjacencyList.containsKey(currentNode)) {
                for (int[] neighbor : adjacencyList.get(currentNode)) {
                    int neighborNode = neighbor[0];
                    int edgeWeight = neighbor[1];

                    if (!visitedNodes.contains(neighborNode)) {
                        int newTotalTime = currentTravelTime + edgeWeight;
                        minHeap.offer(new int[]{newTotalTime, neighborNode});
                    }
                }
            }
        }

        // If all 'n' nodes were reached, return the time for the signal to reach the last node
        return visitedNodes.size() == n ? maxDelayTime : -1;
    }
}
