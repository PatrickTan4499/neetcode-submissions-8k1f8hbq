class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] count = new int[26];
        for(char c : tasks) {
            count[c-'A']++;
        }

        for(int c : count) {
            if(c > 0) {
            maxHeap.offer(c);
            }
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            if(!maxHeap.isEmpty()) {
                int curr = maxHeap.poll()-1;
                if(curr > 0) {
                cooldown.add(new int[]{curr, time + n});
                }
            }

            if(!cooldown.isEmpty()) {
                int[] curr = cooldown.peek();
                if(curr[1] == time) {
                    maxHeap.offer(cooldown.poll()[0]);
                }
            }

            time++;
        }
        return time;
    }
}
