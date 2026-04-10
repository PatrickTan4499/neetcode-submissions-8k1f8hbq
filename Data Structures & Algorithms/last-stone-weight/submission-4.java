class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (b-a));

        for(int stone : stones) {
            minHeap.add(stone);
        }

        while (minHeap.size() >= 2) {
            int stone1 = minHeap.poll();
            int stone2 = minHeap.poll();

            if(stone1 == stone2) {
                continue;
            }

            if(stone1 > stone2) {
                minHeap.add(stone1-stone2);
            }
        }

        if(minHeap.peek() == null) {
            return 0;
        }
        return minHeap.peek();
    }
}
