class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        res.add(intervals[0]);
        for(int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];

            int lastEnd = res.get(res.size()-1)[1];
            if(lastEnd >= start) {
                res.get(res.size() - 1)[1] = Math.max(lastEnd, end);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
        
    }
}
