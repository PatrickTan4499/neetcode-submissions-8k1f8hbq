class Solution {
    public int rob(int[] nums) {
                if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int temp = two;
            two = Math.max(one + nums[i], two);
            one = temp;
        }
        return Math.max(one, two); 
    }
}
