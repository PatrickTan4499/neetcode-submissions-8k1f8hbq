class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp(Arrays.copyOfRange(nums, 1, nums.length)), 
        dp(Arrays.copyOfRange(nums, 0, nums.length-1)));
    }

    private int dp(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for(int n : nums) {
            int newRob = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = newRob;
            
        }
        return rob2;
    }
}
