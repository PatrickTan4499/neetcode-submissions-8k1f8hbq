/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int answer = 0;
        if(intervals == null || intervals.size() == 0) {
            return answer;
        }
        Collections.sort(intervals, (a,b) -> (a.start - b.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> (a.end - b.end));

        for(Interval interval : intervals) {
            if(minHeap.isEmpty()) {
                minHeap.offer(interval);
            } else {
            Interval lastMeeting = minHeap.peek();
            if(lastMeeting.end > interval.start) {
                minHeap.offer(interval);
            } else {
                while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
                    minHeap.poll();
                }
                                minHeap.offer(interval);
            }
            }
            answer = Math.max(minHeap.size(), answer);

        }
        return answer;
    }
}
