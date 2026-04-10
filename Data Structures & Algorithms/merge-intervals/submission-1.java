class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        for(int[] interval : intervals) {
            if(answer.isEmpty()) {
                answer.add(interval);
            } else {
                int[] prev = answer.get(answer.size()-1);

                if(prev[1] < interval[0]) {
                    answer.add(interval);
                } else {
                    prev[0] = Math.min(prev[0], interval[0]);
                    prev[1] = Math.max(prev[1], interval[1]);
                }
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }
}
