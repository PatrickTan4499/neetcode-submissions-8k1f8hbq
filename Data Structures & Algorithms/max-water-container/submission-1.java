class Solution {
    public int maxArea(int[] heights) {
        int answer = 0;
        int start = 0;
        int end = heights.length -1;

        while (start < end) {
            int area = Math.min(heights[start], heights[end]) * (end - start);
            if (area > answer) {
                answer = area;
            }

            if(heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }
        return answer;
    }
}
