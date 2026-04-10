class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int answer = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num : nums) {
            currSum += num;
            answer = Math.max(currSum, answer);

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return answer;
    }
}
