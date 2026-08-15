class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];

            if(newInterval == null || currInterval[1] < newInterval[0]) {
                //add curr interval
                res.add(currInterval);
            } else if(currInterval[0] > newInterval[1]) {
                //add newInterval
                res.add(newInterval);
                res.add(currInterval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(currInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        }
        if(newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
