class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> minHeap = new PriorityQueue<>(
            Comparator.comparing(a -> a.getKey())
        );

        for(int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new Pair<>(dist, point));
        }

        int[][] answer = new int[k][2];
        
        for(int i = 0; i < k; i++) {
            answer[i] = minHeap.poll().getValue();
        }

        return answer;
        
    }
}
