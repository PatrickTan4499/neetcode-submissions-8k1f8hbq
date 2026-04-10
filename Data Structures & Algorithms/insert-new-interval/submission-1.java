class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();

        for(int[] interval : intervals) {
            if(newInterval == null || interval[1] < newInterval[0]) {
                answer.add(interval);
            } else if(interval[0] > newInterval[1]) {
                answer.add(newInterval);
                answer.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);

            }
        }

        if(newInterval != null) {
            answer.add(newInterval);
        }
        return answer.toArray(new int[answer.size()][]);
    }
}
