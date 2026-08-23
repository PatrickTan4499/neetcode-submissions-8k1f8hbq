class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1;
        int currMin = 1;

        for(int i = 0; i< nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(Math.max(nums[i] * currMax, nums[i] * currMin), nums[i]);
            currMin = Math.min(Math.min(nums[i] * temp, nums[i] * currMin), nums[i]);

            res = Math.max(currMax, res);
        }

        return res;
    }
}
