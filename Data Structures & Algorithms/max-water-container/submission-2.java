class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int answer = 0;
        while(start < end) {
            int length = end - start;
            int height = Math.min(heights[start], heights[end]);
            answer = Math.max(answer, height * length);
            if(heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return answer;
    }
}
