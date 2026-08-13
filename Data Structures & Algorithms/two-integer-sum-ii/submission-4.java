class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        int[] answer = new int[2];
        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if(curSum > target) {
                right--;
            } else if (curSum < target) {
                left++;
            } else {
                answer[0] = left+1;
                answer[1] = right+1;
                return answer;
            }

        }
        return answer;
    }
}
